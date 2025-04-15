package com.itheima.demo3annotatior;

@MyBook(name = "赵丽颖",age = 20,address = {"北京","上海"})
//@A(value = "赵丽颖")
//@A("赵丽颖")
//@A(value = "赵丽颖",hobby = "打游戏")
@A("赵丽颖")
public class AnnotatiorDemo1 {
    @MyBook(name = "王菲",age = 52,address = {"香港","上海"})
    public static void main(@A("赵丽颖")String[] args) {
        //目标：自定义注解
        @A("赵丽颖")
        int a;
    }

}
