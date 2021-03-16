package com.example.service.impl;

import cn.hutool.core.lang.Console;
import com.google.common.collect.ImmutableList;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.script.RedisScript;
import org.springframework.scripting.ScriptSource;
import org.springframework.scripting.support.ResourceScriptSource;

import javax.annotation.Resource;
import java.io.IOException;
import java.sql.Time;
import java.util.List;

/**
 * @Author: w00990
 * @Date: 2021/2/26
 */
@SpringBootTest

public class RedisTest {

    @Resource
    private StringRedisTemplate stringRedisTemplate;//lua脚本路径


//    @Resource
//    private RedisCacheManager redisCacheManager;


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
    public void testNN() {
//        redisCacheManager.
    }


    // redis 中没有map返回
    @Test
    public <T> void testTime() {
        Time time = new Time(9, 10, 10);
//        time.setHours(9);
//        time.setMinutes(10);
//
//        time.setSeconds(10);
        System.out.println(time.toString());

    }


    // redis 中没有map返回
    @Test
    public <T> void testLL() {
        RedisScript<List> redisScript = getRedisScript(List.class);
//        String luaScript = "local function multiValue()\n" +
//                "    local result = {};\n" +
//                "    local ret1 = { 1, 2 };\n" +
//                "    local ret2 = \"hello\";\n" +
//                "    result[1] = ret1;\n" +
//                "    result[2] = ret2;\n" +
//                "    return result;\n" +
//                "end\n" +
//                "\n" +
//                "return multiValue()";
//        RedisScript of = RedisScript.of(luaScript, List.class);
//        redisScript.setResult()
        List init = stringRedisTemplate.execute(redisScript,
                ImmutableList.of("asd:asdasd"),
                "init", "CRRBBB", "5");

        Console.log("init=>" + init);
        String endCertId = (String) init.get(1);
        Integer searchIndex = ((Long) init.get(0)).intValue();
    }

    @Test
    public <T> void testAcquire() {


        RedisScript<List> redisScript = getRedisScript(List.class);
        List<T> acquire = stringRedisTemplate.execute(redisScript,
                ImmutableList.of("asd:asdasd"),
                "acquire", "123", "1");
        Console.log("=>" + acquire);

    }

    private static <T> RedisScript<T> getRedisScript(Class<T> resultType) {
        RedisScript<T> script = null;
        if (script != null) {
            return script;
        }

        ScriptSource scriptSource = new ResourceScriptSource(new ClassPathResource("split_silent_sign.lua"));
//        ScriptSource scriptSource = new ResourceScriptSource(new ClassPathResource("rate_limiter.lua"));
        String str = null;
        try {
            str = scriptSource.getScriptAsString();
        } catch (IOException e) {
            e.printStackTrace();
        }

        script = RedisScript.of(str, resultType);
        return script;
    }


}
