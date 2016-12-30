package com.global.task;

import java.util.Map;

/**
 * 任务处理结束句柄,用于处理数据落地操作
 * @auth snifferhu
 * @date 2016/12/30 23:37
 */
public interface TaskDownHandler<I> {
    void invoke(I input, Map context);
}
