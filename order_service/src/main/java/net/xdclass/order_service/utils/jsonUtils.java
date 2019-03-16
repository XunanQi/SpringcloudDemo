package net.xdclass.order_service.utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

/**
 * @Author Ian
 * @Description:
 * @Date 2019/3/14
 */
public class jsonUtils {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    /**
     * 字符串json转对象
     */
    public static JsonNode str2JsonNode(String str){
        JsonNode jsonNode=null;
        try {
            jsonNode = objectMapper.readTree(str);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return jsonNode;
    }


}
