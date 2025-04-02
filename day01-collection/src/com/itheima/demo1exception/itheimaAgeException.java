package com.itheima.demo1exception;

/**
 * 自定义异常类
 * 1、继承Exception
 * 2、重写Exception构造方法
 * 3、哪里需要用这个异常返回，哪里就throw
 */

public class itheimaAgeException extends  Exception{
    public itheimaAgeException() {
    }

    public itheimaAgeException(String message) {
        super(message);
    }

}
