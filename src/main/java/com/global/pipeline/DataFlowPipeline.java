package com.global.pipeline;

import com.global.task.Task;

import java.util.List;
import java.util.Map;

/**
 * @auth snifferhu
 * @date 2016/12/30 22:35
 */
public interface DataFlowPipeline {

    void doTask(Map input, Map context);

    void addTask(Task t);

    void setTaskList(List<Task> taskList);

    List<Task> getTaskList();
}
