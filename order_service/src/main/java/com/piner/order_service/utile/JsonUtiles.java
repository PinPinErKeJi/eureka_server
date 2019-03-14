package com.piner.order_service.utile;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class JsonUtiles {
    private static final ObjectMapper objectMapper = new ObjectMapper();
    /*
    Json字符串转jsonNode对象的方法
     */
    public static JsonNode strJsonNode(String str){
        try {
            return  objectMapper.readTree(str);
        } catch (IOException e) {
           return null;
        }
    }
}
