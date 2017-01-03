package com.global.codec;

import com.global.input.InputHandler;

/**
 * 默认解析工具类
 * 默认情况，不做解析
 * Created by Sniff on 2016/12/31.
 */
public class DefaultCodec implements Codec {
    @Override
    public <T> T explain(InputHandler<T> input) {
        return input.inputValue();
    }
}