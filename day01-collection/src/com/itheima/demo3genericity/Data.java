package com.itheima.demo3genericity;
//自动义泛型接口
public interface Data<T> {
    void add(T s);
    void delete(T s);
    void update(T s);
    T query(int id);
}
