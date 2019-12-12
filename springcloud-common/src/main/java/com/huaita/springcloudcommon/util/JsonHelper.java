package com.huaita.springcloudcommon.util;

import com.huaita.springcloudcommon.dto.DateJsonValueProcessor;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.List;

public final class JsonHelper {
    public static final <T> void list2Json(HttpServletResponse response, List<T> list) {
        JSONArray jsonArray = JSONArray.fromObject(list);
        try {
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(jsonArray.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static final void list2JsonForDate(HttpServletResponse response, List<?> list) {
        JsonConfig jsonConfig = new JsonConfig();
        jsonConfig.registerJsonValueProcessor(Date.class, new DateJsonValueProcessor("yyyy-MM-dd"));
        JSONArray jsonArray = JSONArray.fromObject(list, jsonConfig);
        try {
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(jsonArray.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static final void list2JsonForDateTime(HttpServletResponse response, List<?> list) {
        JsonConfig jsonConfig = new JsonConfig();
        jsonConfig.registerJsonValueProcessor(Date.class, new DateJsonValueProcessor("yyyy-MM-dd"));
        JSONArray jsonArray = JSONArray.fromObject(list, jsonConfig);
        try {
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(jsonArray.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String list2JsonStr(List<?> list) {
        JsonConfig jsonConfig = new JsonConfig();
        jsonConfig.registerJsonValueProcessor(Date.class, new DateJsonValueProcessor("yyyy-MM-dd"));
        JSONArray jsonArray = JSONArray.fromObject(list, jsonConfig);
        return jsonArray.toString();
    }

    public static final String list2Json(List<?> list) {
        JSONArray jsonArray = JSONArray.fromObject(list);
        return jsonArray.toString();
    }

    public static final void bean2Json(HttpServletResponse response, Object object) {
        JSONObject jsonObject = JSONObject.fromObject(object);
        try {
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(jsonObject.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static final String bean2JsonStr(Object object) {
        JsonConfig jsonConfig = new JsonConfig();
        jsonConfig.registerJsonValueProcessor(Date.class, new DateJsonValueProcessor("yyyy-MM-dd"));
        JSONObject jsonObject = JSONObject.fromObject(object, jsonConfig);
        return jsonObject.toString();
    }

    public static final void bean2JsonForDate(HttpServletResponse response, Object object) {
        JsonConfig jsonConfig = new JsonConfig();
        jsonConfig.registerJsonValueProcessor(Date.class, new DateJsonValueProcessor("yyyy-MM-dd"));
        JSONObject jsonObject = JSONObject.fromObject(object, jsonConfig);
        try {
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(jsonObject.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static final void bean2JsonForDateTime(HttpServletResponse response, Object object) {
        JsonConfig jsonConfig = new JsonConfig();
        jsonConfig.registerJsonValueProcessor(Date.class, new DateJsonValueProcessor("yyyy-MM-dd HH:mm:ss"));
        JSONObject jsonObject = JSONObject.fromObject(object, jsonConfig);
        try {
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(jsonObject.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static final void bool2Json(HttpServletResponse response, boolean result) {
        str2Json(response, String.valueOf(result));
    }

    public static final void str2Json(HttpServletResponse response, String str) {
        try {
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(str);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
