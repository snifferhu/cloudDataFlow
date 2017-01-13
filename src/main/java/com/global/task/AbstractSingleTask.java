package com.global.task;

import com.global.codec.Codec;
import com.global.codec.DefaultCodec;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * todo 完成抽象模板定义
 * @auth snifferhu
 * @date 2016/12/31 00:06
 */
public abstract class AbstractSingleTask implements Task {
    private final Logger logger = LoggerFactory.getLogger(getClass());
    protected Codec codec;
    @Override
    public void invoke(Map<String,Object> input, Map<String,Object> context) {
        Map<String,Object> result = Optional.ofNullable(codec)
                .orElseGet(DefaultCodec::new)
                .explain(input);
        doTask(result,context);
    }

    protected abstract void doTask(Map<String,Object> explain, Map context);


    protected void setCodec(Codec codec) {
        this.codec = codec;
    }
}
