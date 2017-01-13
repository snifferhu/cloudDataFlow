package com.global.codec;


import java.util.HashMap;
import java.util.Map;

/**
 * 默认解析工具类
 * 默认情况，不做解析
 * Created by Sniff on 2016/12/31.
 */
public class DefaultCodec implements Codec {

    @Override
    public Map explain(Map<String,Object> input) {
        return input;
    }
}