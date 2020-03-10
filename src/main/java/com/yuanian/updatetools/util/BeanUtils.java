package com.yuanian.updatetools.util;

import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationTargetException;

/**
 * @author pantao
 * @since 2018/1/18
 */
public class BeanUtils {

    private static final String ERROR_JSON = "{\"error\":\"internal error, please try again later\"}";

    private static Logger logger = LoggerFactory.getLogger(BeanUtils.class);

    private BeanUtils() {}

    /**
     * 将权限字符串装换成权限数组
     *
     * @param auth 权限字符串
     *
     * @return 权限数组
     */
    public static int[] getAuth(String auth) {
        int[] a = new int[5];

        return a;
    }

    /**
     * 将Bean转换成JSON
     *
     * @param object Bean对象
     *
     * @return {@link String}
     */
    public static String toPrettyJson(Object object) {
        String result = null;

        return result;
    }

    /**
     * 将类属性装换成JSON（只能转换有get方法的）
     *
     * @param object 转换的对象
     *
     * @return {@link JSONObject}
     */
    public static JSONObject beanToJson(Object object) {
        return null;
    }
}
