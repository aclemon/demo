--
-- Created by IntelliJ IDEA.
-- User: w00990
-- Date: 2021/3/5
-- Time: 10:14
-- To change this template use File | Settings | File Templates.

local function acquire(key, permits, cert_id, curr_mill_second)
    local rate_limit_info = redis.pcall("HMGET", key, "last_mill_second", "curr_permits", "max_permits", "period");
    local last_mill_second = tonumber(rate_limit_info[1]);
    local curr_permits = tonumber(rate_limit_info[2]);
    local max_permits = tonumber(rate_limit_info[3]);
    local period = tonumber(rate_limit_info[4]);
    local cc = tonumber(curr_mill_second);
    local pp = tonumber(permits);
    if (max_permits == nil) then
        return 1;
    end
    local local_curr_permits = max_permits;
    if (type(last_mill_second) ~= 'boolean' and last_mill_second ~= nil) then
        local reverse_permits = math.floor((cc - last_mill_second) / (period * 1000)) * max_permits;
        local expect_curr_permits = reverse_permits + curr_permits;
        local_curr_permits = math.min(expect_curr_permits, max_permits);

        if (reverse_permits > 0) then
            redis.pcall("HSET", key, "last_mill_second", curr_mill_second);
        end
    else
        redis.pcall("HSET", key, "last_mill_second", curr_mill_second);
    end
    local result = {};
    if (local_curr_permits - pp >= 0) then
        redis.pcall("HSET", key, "curr_permits", local_curr_permits - pp);
        redis.pcall("HSET", key, "cert_id", cert_id);
        result[1] = local_curr_permits - pp;
        result[2] = redis.pcall("HGET", key, "cert_id");
    else
        redis.pcall("HSET", key, "curr_permits", 0);
    end

    return result;
end

return acquire("asd:asd", "1", "C1234567", "1615192828000")


--local function multiValue()
--    local result = {};
--    local ret1 = { 1, 2 };
--    local ret2 = "hello";
--    result[1] = ret1;
--    result[2] = ret2;
--    return result;
--end
--
--return multiValue()