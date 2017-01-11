package com.codeup.util;

public class JsonUtils {

    public static String toJsonField(String name, String value) {
        return "\"" + name + "\":\"" + value + "\"";
    }
}
