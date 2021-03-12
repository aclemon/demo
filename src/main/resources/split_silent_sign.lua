--
-- Created by IntelliJ IDEA.
-- User: w00990
-- Date: 2021/3/9
-- Time: 10:04
-- To change this template use File | Settings | File Templates.
--


--- 获取令牌
--- 返回码
--- 0 没有令牌桶配置
--- -1 表示取令牌失败，也就是桶里没有令牌
--- 1 表示取令牌成功
--- @param key 令牌的唯一标识
--- @param permits 请求令牌数量
local function acquire(key, cert_id, permits)
    local rate_limit_info = redis.pcall("HMGET", key, "curr_permits", "max_permits", "cert_id");
    local curr_permits = tonumber(rate_limit_info[1]);
    local max_permits = tonumber(rate_limit_info[2]);
    local redis_cert_id = rate_limit_info[3];

    --- 如果获取令牌的时候最大令牌数不存在，说明这个令牌桶已经被删除复位了，忽略本次请求，认为可以获得令牌
    if (max_permits == nil) then
        return 1;
    end
    --- 首次创建时，令牌数量为permits，满足第一次请求需要
    local local_curr_permits = curr_permits;
    local result = {};
    if (local_curr_permits - permits > 0) then
        redis.pcall("HSET", key, "curr_permits", local_curr_permits - permits);
        result[1] = local_curr_permits - permits;
        result[2] = redis_cert_id;
    else
        --- 否则令牌数重置更新cert_id
        if (cert_id == "") then
            redis.pcall("HMSET", key, "curr_permits", local_curr_permits - permits);
            --- 可能为负数
            result[1] = local_curr_permits - permits;
            result[2] = redis_cert_id;
        else
            redis.pcall("HMSET", key, "curr_permits", max_permits, "cert_id", cert_id);
            result[1] = max_permits;
            result[2] = cert_id;
        end
    end

    return result;
end






--- 初始化令牌桶配置
--- @param key 令牌的唯一标识
--- @param max_permits 桶大小
local function init(key, cert_id, max_permits)
    local rate_limit_info = redis.pcall("HMGET", key, "curr_permits", "max_permits", "cert_id")
    local curr_permits = tonumber(rate_limit_info[1])
    local org_max_permits = tonumber(rate_limit_info[2])
    local org_cert_id = rate_limit_info[3]

    local result = {};
    result[1] = 0;
    --- 如果curr_permits不存在，或者都大于最大值，否则不设置，这样配置变更时不会影响已经统计的结果
    local num_max_permits = tonumber(max_permits)
    if (curr_permits == nil) or (num_max_permits < curr_permits) then
        --- 重新计数
        redis.pcall("HMSET", key, "curr_permits", max_permits)
        result[1] = 1
    end
    --- if 初次创建 else 再次执行init
    if (org_max_permits == nil) or (num_max_permits ~= org_max_permits) then
        redis.pcall("HMSET", key, "max_permits", max_permits, "cert_id", cert_id)
        result[2] = max_permits;
        result[3] = cert_id;
    else
        result[2] = curr_permits - 1;
        redis.pcall("HMSET", key, "curr_permits", curr_permits - 1);
        result[3] = org_cert_id;
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
    local result = {};
    if redis.pcall("EXISTS", key) == 1 then

        result[1] = 1;
        return result;
    else
        result[1] = 0;
        return result;
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
else
    --ignore
end