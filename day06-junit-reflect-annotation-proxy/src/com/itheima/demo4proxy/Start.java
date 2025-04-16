package com.itheima.demo4proxy;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Start implements StartService{
    private String name;

    @Override
    public void sing(String name) {
        System.out.println(this.name + "在唱歌" + name);
    }

    @Override
    public String dance() {
        System.out.println(this.name + "在跳舞");
        return "谢谢！";
    }
}
