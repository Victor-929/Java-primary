package com.itheima.demo1exception;

/**
 * 自定义异常类
 * 1、继承RuntimeException
 * 2、重写RuntimeException构造方法
 * 3、哪里需要用这个异常返回，哪里就throw
 */

public class itheimaAgeRuntimeException extends  RuntimeException{
    public itheimaAgeRuntimeException() {
    }

    public itheimaAgeRuntimeException(String message) {
        super(message);
    }

}
