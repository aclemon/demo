package com.example.util;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * @Author: w00990
 * @Date: 2021/1/25
 */
@Slf4j
public class PaymentJsonUtil {

    private static final ObjectMapper mapper = new ObjectMapper();

    static {
        mapper.setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
        mapper.configure(SerializationFeature.WRITE_ENUMS_USING_INDEX, true);
        mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        mapper.configure(SerializationFeature.ORDER_MAP_ENTRIES_BY_KEYS, true);
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        mapper.registerModule(new JavaTimeModule());
    }

    public static Map<String, Object> obj2Map(Object obj) {
        // 这里不能直接使用Map<String, String>, 因为像int，long, number这类数据不能转为String
        Map<String, Object> map = mapper.convertValue(obj, new TypeReference<Map<String, Object>>() {

        });
        return new TreeMap<>(map);
    }

    /**
     * 对象转换为字符串出错
     *
     * @param obj
     * @return
     */
    public static String obj2Str(Object obj) {
        try {
            return mapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            log.error("序列化对象出错：{}", obj);
            throw new RuntimeException();
        }

    }

    /**
     * 字符串转为对象
     *
     * @param str
     * @return
     */
    public static <T> T str2Obj(String str, Class<T> clz) {
        try {
            return mapper.readValue(str, clz);
        } catch (IOException e) {
            log.error("序列化对象出错：{}", str, e);
            throw new RuntimeException();
        }

    }

    /**
     * 字符串转为对象
     *
     * @param str
     * @return
     */
//    public static <T> T str2Obj(String str, TypeReference<?> valueTypeRef) {
//        try {
//            return (T) mapper.readValue(str, valueTypeRef);
//        } catch (IOException e) {
//            log.error("序列化对象出错：{}", str);
//            throw new RuntimeException();
//        }
//    }


    /**
     * 对象转换为字符串出错
     *
     * @param map
     * @return
     */
    public static <T> T map2Obj(Map<String, ?> map, Class<T> cls) {
        return mapper.convertValue(map, cls);
    }

    /**
     * TreeMa集合2String
     *
     * @param data TreeMa
     * @return String
     */
    public static String coverMap2String(SortedMap<String, Object> data) {
        StringBuilder sf = new StringBuilder();
        for (String key : data.keySet()) {
            if (StringUtils.isNotBlank((String) data.get(key))) {
                sf.append(key).append("=").append((String.valueOf(data.get(key))).trim()).append("&");
            }
        }
        return sf.substring(0, sf.length() - 1);
    }
}
