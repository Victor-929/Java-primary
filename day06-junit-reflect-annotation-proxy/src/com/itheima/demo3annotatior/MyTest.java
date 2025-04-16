package com.itheima.demo3annotatior;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)// 表示该注解只能用于方法上
@Retention(RetentionPolicy.RUNTIME)//表示注解的保留策略：编译器运行时（一直活着）
public @interface MyTest {

}
