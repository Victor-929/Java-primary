package com.itheima.demo2genericity;

import java.util.ArrayList;

//泛型类
public class MyArrayList<E>{

    private ArrayList list = new ArrayList();
    public boolean add (E e){
        list.add(e);
        return true;
    }
    public boolean remove (E e){
            return list.remove(e);
    }

    @Override
    public String toString(){
        return list.toString();
    }
}
