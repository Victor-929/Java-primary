package com.itheima.demo1;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Test4 {
    public static void main(String[] args) {
        //1、定义对象存储每种液体数据
        //2、定义一个List集合存储每种液体对象
        Liquid water = new Liquid("水", 4, 24);
        Liquid milk = new Liquid("牛奶", 8, 160);
        Liquid wine = new Liquid("五粮液", 2, 4000);
        Liquid cola = new Liquid("可乐", 6, 108);
        Liquid maotai = new Liquid("茅台", 1, 4000);
        List<Liquid> liquids = new ArrayList<>();
        Collections.addAll(liquids, water, milk, wine, cola, maotai);
        //3、对List集合按照每升单价降序排序
        liquids =  liquids.stream().sorted((o1, o2) -> Double.compare(o2.getPrice(),o1.getPrice())).collect(Collectors.toList());
        //4、遍历集合从前往后选10升液体，就是最贵的液体
        double total = 0;//最高价值
        int all = 10;//10升
        for (int i = 0; i < liquids.size(); i++) {
            Liquid liquid = liquids.get(i);
           //判断是否达到了10升
            int volume = liquid.getVolume();
            if(volume >= all){
                System.out.println(liquid.getName()+"提取了"+all+"升");
                total += liquid.getPrice()*all;
                break;
            } else {
                System.out.println(liquid.getName()+"提取了"+volume+"升");
                total += liquid.getPrice()*volume;
                all -= volume;//剩余还需要升数
            }
        }
        System.out.println("总价值："+total);
    }
}
@Data
@NoArgsConstructor
@AllArgsConstructor
class Liquid{
    private String name;//液体名称
    private int volume;//总量
    private int value;//总价值
    //计算每升单价
    public double getPrice(){
        //精确运算
        BigDecimal value = new BigDecimal(this.value);
        BigDecimal volume = new BigDecimal(this.volume);
        return value.divide(volume,2,BigDecimal.ROUND_HALF_UP).doubleValue();
    }
}
