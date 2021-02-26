---
--- Created by wukaiqiang.
--- DateTime: 2017/11/9 下午6:39
---

--- 获取令牌
--- 返回码
--- 0 没有令牌桶配置
--- -1 表示取令牌失败，也就是桶里没有令牌
--- 1 表示取令牌成功
--- @param key 令牌的唯一标识
--- @param permits 请求令牌数量
--- @param curr_mill_second 当前毫秒数
local function acquire(key, permits, curr_mill_second)
    local rate_limit_info = redis.pcall("HMGET", key, "last_mill_second", "curr_permits", "max_permits", "period")
    local last_mill_second = rate_limit_info[1]
    local curr_permits = tonumber(rate_limit_info[2])
    local max_permits = tonumber(rate_limit_info[3])
    local period = rate_limit_info[4]

    -- 如果获取令牌的时候最大令牌数不存在，说明这个令牌桶已经被删除复位了，忽略本次请求，认为可以获得令牌
    if (max_permits == nil) then
        return 1;
    end
    --- 首次创建时，令牌数量为permits，满足第一次请求需要
    local local_curr_permits = max_permits;

    --- 令牌桶刚刚创建，上一次获取令牌的毫秒数为空
    --- 根据和上一次向桶里添加令牌的时间和当前时间差，触发式往桶里添加令牌，并且更新上一次向桶里添加令牌的时间
    --- 如果向桶里添加的令牌数不足一个，则不更新上一次向桶里添加令牌的时间
    if (type(last_mill_second) ~= 'boolean' and last_mill_second ~= nil) then
        local reverse_permits = math.floor((curr_mill_second - last_mill_second) / (period * 1000)) * max_permits
        local expect_curr_permits = reverse_permits + curr_permits;
        local_curr_permits = math.min(expect_curr_permits, max_permits);

        --- 大于0表示要添加令牌，需要更新last_mill_second
        if (reverse_permits > 0) then
            redis.pcall("HSET", key, "last_mill_second", curr_mill_second)
        end
    else
        redis.pcall("HSET", key, "last_mill_second", curr_mill_second)
    end


    local result = {}
    result.permit = -1
    return result
    --    local result = -1
    --    if (local_curr_permits - permits >= 0) then
    --        result = local_curr_permits - permits
    --        --- result.cert_id = redis.pcall("HGET", key, "cert_id")
    --        redis.pcall("HSET", key, "curr_permits", local_curr_permits - permits)
    --    else
    --        --- 否则令牌数归零
    --        redis.pcall("HSET", key, "curr_permits", 0)
    --    end
    --
    --    return result
end


--- 获取消耗令牌
--- 返回码
--- 0 没有令牌桶配置
--- -1 表示取令牌失败，也就是桶里没有令牌
--- 1 表示取令牌成功
--- @param key 令牌的唯一标识
--- @param curr_mill_second 当前毫秒数
local function usedTokens(key, curr_mill_second)
    local rate_limit_info = redis.pcall("HMGET", key, "last_mill_second", "curr_permits", "max_permits", "period")
    local last_mill_second = rate_limit_info[1]
    local curr_permits = tonumber(rate_limit_info[2])
    local max_permits = tonumber(rate_limit_info[3])
    local period = rate_limit_info[4]

    -- 如果获取令牌的时候最大令牌数不存在，说明这个令牌桶已经被删除复位了，忽略本次请求，返回-1
    if (max_permits == nil) then
        return -1;
    end

    local local_curr_permits = max_permits;


    --- 令牌桶刚刚创建，上一次获取令牌的毫秒数为空
    --- 根据和上一次向桶里添加令牌的时间和当前时间差，触发式往桶里添加令牌，并且更新上一次向桶里添加令牌的时间
    --- 如果向桶里添加的令牌数不足一个，则不更新上一次向桶里添加令牌的时间
    if (type(last_mill_second) ~= 'boolean' and last_mill_second ~= nil and type(period) ~= 'boolean' and period ~= nil) then
        local reverse_permits = math.floor((curr_mill_second - last_mill_second) / (period * 1000)) * max_permits
        local expect_curr_permits = reverse_permits + curr_permits;
        --- 这里只计算理论的剩余令牌数，不对令牌做增减炒作
        local_curr_permits = math.min(expect_curr_permits, max_permits);
    end

    return max_permits - local_curr_permits
end



--- 初始化令牌桶配置
--- @param key 令牌的唯一标识
--- @param max_permits 桶大小
--- @param period 令牌增加间隔
local function init(key, max_permits, period)
    local rate_limit_info = redis.pcall("HMGET", key, "last_mill_second", "curr_permits", "max_permits", "period")
    local curr_permits = tonumber(rate_limit_info[2])
    local org_max_permits = tonumber(rate_limit_info[3])
    local org_period = rate_limit_info[4]

    local result = 0
    --- 如果curr_permits不存在，或者都大于最大值，否则不设置，这样配置变更时不会影响已经统计的结果
    local num_max_permits = tonumber(max_permits)
    if (curr_permits == nil) or (num_max_permits < curr_permits) then
        --- 重新计数
        redis.pcall("HMSET", key, "curr_permits", max_permits)
        result = 1
    end

    if (org_max_permits == nil) or (period ~= org_period or num_max_permits ~= org_max_permits) then
        redis.pcall("HMSET", key, "max_permits", max_permits, "period", period)
    end
    --- 新建成功，return 1, 如果只是修改 return 0
    return result;
end


--- 删除令牌桶
local function delete(key)
    redis.pcall("DEL", key)
    return 1;
end

--- 检查令牌桶是否存在
local function exists(key)
    if redis.pcall("EXISTS", key) == 1 then
        return 1
    else
        return 0
    end
end


local key = KEYS[1]
local method = ARGV[1]

if method == 'acquire' then
    return acquire(key, ARGV[2], ARGV[3])
elseif method == 'init' then
    return init(key, ARGV[2], ARGV[3])
elseif method == 'delete' then
    return delete(key)
elseif method == 'exists' then
    return exists(key)
elseif method == 'usedTokens' then
    return usedTokens(key, ARGV[2])
else
    --ignore
end












