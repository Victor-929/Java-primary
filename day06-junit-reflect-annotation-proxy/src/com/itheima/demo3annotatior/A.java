package com.itheima.demo3annotatior;

public @interface A {
    String value();//特殊属性，默认在使用时如果只有一个属性，那么这个属性名可以省略
    String hobby() default "打游戏";
}
