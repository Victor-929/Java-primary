package com.itheima.demo2reflect;

public class ReflectDemo4 {
    public static void main(String[] args) throws Exception {
        //目标：搞清楚反射的应用，做框架的通用技术
        Dog dog = new Dog("旺财", 3);
        SaveObjectFrameWork.saveObject(dog);
        //创建学生对象
        Student stu = new Student("小明", 18, "篮球");
        SaveObjectFrameWork.saveObject(stu);

        //创建老师对象
        Teacher tea = new Teacher("小红", 30, "java", 5000,"422期","广东","1234567898");
        SaveObjectFrameWork.saveObject(tea);

    }
}
