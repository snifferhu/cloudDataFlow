package com.global.input;

/**
 * 数据接收任务句柄
 * 实现接口自定义数据接收源，通过inputValue方法向框架提供支持
 * Created by Sniff on 2016/12/31.
 */
public interface InputHandler<T> {
    T inputValue();
}
