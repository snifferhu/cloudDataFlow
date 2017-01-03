package com.global.common;

import org.apache.commons.lang3.StringUtils;

import java.util.Map;

/**
 * 校验工具类
 * Created by Sniff on 2016/12/31.
 */
public class ValidateTools {
    private static final String REQUIRED = "params is required";

    public static void NotNull(Object o) throws IllegalArgumentException {
        if (o instanceof String && StringUtils.isBlank((CharSequence) o)) {
            throw new IllegalArgumentException(REQUIRED);
        }
        if (o instanceof Map && ((Map) o).isEmpty()) {
            throw new IllegalArgumentException(REQUIRED);
        }
        if (o == null){
            throw new IllegalArgumentException(REQUIRED);
        }
    }
}
