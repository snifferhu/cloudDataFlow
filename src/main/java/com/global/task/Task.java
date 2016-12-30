package com.global.task;

import java.util.Map;

/**
 * 任务处理接口
 * @auth snifferhu
 * @date 2016/12/30 22:38
 */
public interface Task<I> {

    void invoke(I input, Map context);
}
