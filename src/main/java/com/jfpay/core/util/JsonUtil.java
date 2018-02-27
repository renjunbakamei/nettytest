package com.jfpay.core.util;


import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

public class JsonUtil {

    public static final TypeReference<Map<String, Object>> MAP_REFERENCE = new TypeReference<Map<String, Object>>() {
    };

    private static final Logger logger = LoggerFactory.getLogger(JsonUtil.class);

    private static ObjectMapper objectMapper = new ObjectMapper();

    /**
     * 将对象转换为JSON字符串
     *
     * @param obj
     * @return
     */
    public static String toJson(Object obj) {
        try {
            return objectMapper.writeValueAsString(obj);
        } catch (Exception e) {
            logger.error("json序列化异常", e);
            throw new IllegalArgumentException("转换为JSON字符串时异常", e);
        }
    }

    /**
     * 将JSON字符串转换为对象
     *
     * @param json
     * @param clazz
     * @return
     */
    public static <T> T parse(String json, Class<T> clazz) {
        try {
            objectMapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_CONTROL_CHARS, true) ;
            return objectMapper.readValue(json, clazz);
        } catch (Exception e) {
            logger.error("json反序列化异常", e);
            throw new IllegalArgumentException("由JSON字符串时转换为对象时异常", e);
        }
    }

    /**
     * 将JSON字符串转换为对象
     *
     * @param json
     * @param valueTypeRef
     * @return
     */
    public static <T> T parse(String json, TypeReference<T> valueTypeRef) {
        try {
            objectMapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_CONTROL_CHARS, true) ;
            objectMapper.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);
            return objectMapper.readValue(json, valueTypeRef);
        } catch (Exception e) {
            logger.error("json反序列化异常", e);
            throw new IllegalArgumentException("由JSON字符串时转换为对象时异常", e);
        }
    }
}
