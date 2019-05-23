package com.manong.portal.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * @author APPLE
 * @author 2019-05-13 下午9:46
 * @description Java对象和JSON数据之间的转化
 */
public class GsonUtils {

    private static Gson gson = null;

    static {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gson = gsonBuilder.create();
    }
//  生成个JSON
    public static String toJson(Object object){
        return gson.toJson(object);
    }
//  解析JSON
    public static <T> T fromJson(Class<T> clazz,String json){
        return gson.fromJson(json,clazz);
    }
}
