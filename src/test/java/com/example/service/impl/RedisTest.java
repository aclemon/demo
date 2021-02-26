package com.example.service.impl;

import cn.hutool.core.lang.Console;
import com.google.common.collect.ImmutableList;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.script.RedisScript;
import org.springframework.scripting.ScriptSource;
import org.springframework.scripting.support.ResourceScriptSource;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;

/**
 * @Author: w00990
 * @Date: 2021/2/26
 */
@SpringBootTest

public class RedisTest {

    @Resource
    private StringRedisTemplate stringRedisTemplate;//lua脚本路径


    public static final StringBuilder USER_AIMS_GOLD_LUA = new StringBuilder();

    static {

        USER_AIMS_GOLD_LUA.append(" local comment_user_key=KEYS[1]");
        USER_AIMS_GOLD_LUA.append(" local gold=ARGV[1]");
        USER_AIMS_GOLD_LUA.append(" local redis_gold=redis.call('GET',comment_user_key)");
        USER_AIMS_GOLD_LUA.append(" if redis_gold ");
        USER_AIMS_GOLD_LUA.append(" then ");
        USER_AIMS_GOLD_LUA.append(" redis_gold=tonumber(redis_gold)+tonumber(gold) ");
        USER_AIMS_GOLD_LUA.append(" else ");
        USER_AIMS_GOLD_LUA.append(" redis_gold=tonumber(gold) ");
        USER_AIMS_GOLD_LUA.append(" end ");
        USER_AIMS_GOLD_LUA.append(" redis.call('SET',comment_user_key,redis_gold)");
        USER_AIMS_GOLD_LUA.append(" redis_gold=redis.call('GET',comment_user_key)");
        USER_AIMS_GOLD_LUA.append(" return redis_gold ");
//        log.info(USER_AIMS_GOLD_LUA.toString());
        System.out.println(USER_AIMS_GOLD_LUA);
    }


    @Test
    public void testLL() {
        RedisScript<Long> redisScript = getRedisScript();

        Long result = stringRedisTemplate.execute(redisScript,
                ImmutableList.of("asd:asd"),
                "init", "10", "123456");

        Console.log("=>" + result);
    }

    @Test
    public void testAcquire() {

        Long currMillSecond = stringRedisTemplate.execute(new RedisCallback<Long>() {
            @Override
            public Long doInRedis(RedisConnection connection) throws DataAccessException {
                return connection.time();
            }
        });
        RedisScript<List<Object>> redisScript = getRedisScript();
        assert currMillSecond != null;
        List<Object> acquire = stringRedisTemplate.execute(redisScript,
                ImmutableList.of("asd:asd"),
                "acquire", "1", currMillSecond.toString());
        Console.log("=>" + acquire);
    }

    private static <T> RedisScript<T> getRedisScript() {
        RedisScript<T> script = null;
        if (script != null) {
            return script;
        }

        ScriptSource scriptSource = new ResourceScriptSource(new ClassPathResource("rate_limiter.lua"));
        String str = null;
        try {
            str = scriptSource.getScriptAsString();
        } catch (IOException e) {
            e.printStackTrace();
        }

        script = RedisScript.of(str);
        return script;
    }


}
