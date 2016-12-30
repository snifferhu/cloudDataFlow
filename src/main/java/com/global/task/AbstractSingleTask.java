package com.global.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

/**
 * todo 完成抽象模板定义
 * @auth snifferhu
 * @date 2016/12/31 00:06
 */
public abstract class AbstractSingleTask<I> implements Task<I> {
    private final Logger logger = LoggerFactory.getLogger(getClass());
    @Override
    public void invoke(I input, Map context) {

    }
}
