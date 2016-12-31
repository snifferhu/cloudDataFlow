package com.global.codec;

import com.global.input.InputHandler;

/**
 * 消息解析处理接口
 * Created by Sniff on 2016/12/31.
 */
public interface Codec {
    <T> T explain(InputHandler<T> input);
}
