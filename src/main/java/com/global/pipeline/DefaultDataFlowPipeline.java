package com.global.pipeline;

import com.global.task.Task;
import com.global.output.TaskDownHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;
import java.util.function.Supplier;

import static java.lang.String.format;
import static com.global.common.ValidateTools.NotNull;

/**
 * todo 1.解耦初始化过程，通过工厂模式简化
 *
 * @auth snifferhu
 * @date 2016/12/30 22:45
 */
public abstract class DefaultDataFlowPipeline implements DataFlowPipeline {
    private final Logger logger = LoggerFactory.getLogger(getClass());
    private static final String ERROR_MSG = "Task list is required,taskList=%s";
    protected List<Task> tList = new ArrayList<>();
    protected TaskDownHandler taskDownHandler = null;

    public DefaultDataFlowPipeline() {
    }

    public void doTask(Map input, Map context) {
        NotNull(input);
        NotNull(taskDownHandler);
        Optional.ofNullable(tList)
                .orElseThrow((Supplier<RuntimeException>) () -> {
                    logger.error(ERROR_MSG, tList);
                    return new IllegalArgumentException(format(ERROR_MSG, tList));
                }).forEach(task -> task.invoke(input, context));
        taskDownHandler.exec(input, context);
    }

    public void addTask(Task t) {
        tList.add(t);
    }

    /**
     * 深拷贝list对象,防止对象泄露
     *
     * @return
     */
    public List<Task> getTaskList() {
        List<Task> dic = new ArrayList<>(Arrays.asList(new Task[tList.size()]));
        Collections.copy(dic, tList);
        return dic;
    }

    /**
     * 由子类实现,定义具体需要装入的任务类型
     *
     * @param taskList 处理任务队列
     */
    public abstract void setTaskList(List<Task> taskList);


    /**
     * 由子类实现,定义具体需要装入的任务处理结束句柄类型
     *
     * @param td 任务处理结束句柄
     */
    public abstract void setTaskDown(TaskDownHandler td);
}
