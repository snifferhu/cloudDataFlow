package com.global.pipeline;

import com.global.task.Task;

import java.util.List;
import java.util.Map;

/**
 * @auth snifferhu
 * @date 2016/12/30 22:35
 */
public interface DataFlowPipeline<I> {

    void map(I input, Map context);

    void addTasK(Task t);

    void setTasKList(List<Task> taskList);

    List<Task> getTaskList();
}
