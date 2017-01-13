package com.global.codec;

import java.util.HashMap;
import java.util.Map;

/**
 * 消息解析处理接口
 * Created by Sniff on 2016/12/31.
 */
public interface Codec {
    Map explain(Map<String,Object> input);
}
