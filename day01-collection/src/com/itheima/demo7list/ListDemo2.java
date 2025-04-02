package com.itheima.demo7list;

import java.util.LinkedList;

public class ListDemo2 {
    public static void main(String[] args) {
        //目标：用LinkedList做一个队列对象
        LinkedList<String> queue = new LinkedList<>();
        //入队
        queue.addLast("赵敏");
        queue.addLast("周芷若");
        queue.addLast("张无忌");
        queue.addLast("小昭");
        queue.addLast("殷离");
        System.out.println(queue);

        //出队
        System.out.println(queue.removeFirst());
        System.out.println(queue.removeFirst());
        System.out.println(queue);

        System.out.println("------------------");

        //做一个栈
        LinkedList<String> stack = new LinkedList<>();
        //压栈
        stack.push("赵敏");
        stack.push("周芷若");
        stack.push("张无忌");
        stack.push("小昭");
        stack.push("殷离");
        System.out.println(stack);

        //出栈
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack);

    }
}
