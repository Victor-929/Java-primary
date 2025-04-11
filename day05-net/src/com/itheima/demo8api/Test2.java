package com.itheima.demo8api;

public class Test2 {
    public static void main(String[] args) {
        //目标：高效拼接字符串
        //+号拼接字符串内容，如果是大量拼接，效率极差！
        //String的对象是不可变变量：共享数据性能好，但修改数据性能差！
//        String s = "";
//        for (int i = 0; i < 1000000; i++) {
//            s += "abc";
//        }
//        System.out.println(s);

        //定义字符串可以使用String类型，但操作字符串建议大家用StringBuilder类型
        StringBuilder sb = new StringBuilder();//StringBuilder的对象是可变内容的容器 sb="";
        for (int i = 0; i < 1000000; i++) {
            sb.append("abc");
        }
        System.out.println(sb);
        //StingBuilder只是拼接字符串的手段，结果还是要恢复成字符串
        System.out.println("----------------");
        String s = sb.toString();
        System.out.println(s);

        StringBuilder sb2 = new StringBuilder();
        String result = sb2.append("abc").append("def").append("李四").toString();
        System.out.println(result);
    }
}
