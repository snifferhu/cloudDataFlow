package com.global.codec;

import com.global.input.InputHandler;

/**
 * Created by Sniff on 2016/12/31.
 */
public class DefaultCodec implements Codec {
    @Override
    public <T> T explain(InputHandler<T> input) {
        return input.inputValue();
    }
}
