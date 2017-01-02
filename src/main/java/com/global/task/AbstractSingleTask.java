package com.global.task;

import com.global.codec.Codec;
import com.global.codec.DefaultCodec;
import com.global.input.InputHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.Optional;
import java.util.function.Supplier;

/**
 * todo 完成抽象模板定义
 * @auth snifferhu
 * @date 2016/12/31 00:06
 */
public abstract class AbstractSingleTask implements Task {
    private final Logger logger = LoggerFactory.getLogger(getClass());
    protected Codec codec;
    @Override
    public <T> void invoke(InputHandler<T> input, Map context) {
        T t = Optional.ofNullable(codec)
                .orElseGet(DefaultCodec::new)
                .explain(input);
        doTask(t,context);
    }

    protected abstract <T> void doTask(T t, Map context);

    public void setCodec(Codec codec) {
        this.codec = codec;
    }
}
