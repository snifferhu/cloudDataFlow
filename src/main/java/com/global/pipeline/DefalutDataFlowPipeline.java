package com.global.pipeline;

import com.global.task.Task;
import com.global.task.TaskDownHandler;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;
import java.util.function.Supplier;

import static java.lang.String.format;

/**
 * @auth snifferhu
 * @date 2016/12/30 22:45
 */
public abstract class DefalutDataFlowPipeline<I> implements DataFlowPipeline<I> {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    protected List<Task> tList = new ArrayList<>();

    private TaskDownHandler<I> taskDownHandler = null;

    public DefalutDataFlowPipeline() {
    }

    private static final String ERROR_MSG = "Task list is required,taskList={}";
    private static final String REQUIRED = "params is required";

    public void map(I input, Map context) {
        NotNull(input);
        NotNull(context);
        NotNull(taskDownHandler);
        Optional.ofNullable(tList)
                .orElseThrow((Supplier<RuntimeException>) () -> {
                    logger.error(ERROR_MSG, tList);
                    return new IllegalArgumentException(format(ERROR_MSG, tList));
                }).parallelStream().forEach(x -> x.invoke(input, context));
        taskDownHandler.invoke(input,context);
    }

    public void addTasK(Task t) {
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
    public abstract void setTasktList(List<Task> taskList);


    /**
     * 由子类实现,定义具体需要装入的任务处理结束句柄类型
     *
     * @param td 任务处理结束句柄
     */
    public abstract void setTaskDown(TaskDownHandler td);

    private void NotNull(Object o) throws IllegalArgumentException {
        if (o instanceof String && StringUtils.isBlank((CharSequence) o)) {
            logger.error(REQUIRED);
            throw new IllegalArgumentException(REQUIRED);
        }
        if (o instanceof Map && ((Map) o).isEmpty()) {
            logger.error(REQUIRED);
            throw new IllegalArgumentException(REQUIRED);
        }
        if (o == null){
            logger.error(REQUIRED);
            throw new IllegalArgumentException(REQUIRED);
        }
    }
}
