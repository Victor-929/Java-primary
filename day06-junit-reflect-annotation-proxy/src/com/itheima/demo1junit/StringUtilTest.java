package com.itheima.demo1junit;


import org.junit.Assert;
import org.junit.Test;

//测试类：junit单元测试框架，对业务中的业务进行正确性测试。
public class StringUtilTest {
    //测试方法必须是公开public，无参，无返回值
    //测试方法必须加上@Test注解（Junit框架的核心步骤）
    @Test
    public void testprintNumber() {
        //测试步骤
        StringUtil.printNumber("张三abc");//5
        //测试用例
        StringUtil.printNumber("");
        StringUtil.printNumber(null);
    }
    @Test
    public void testgetMaxIndex() {
        //测试步骤
        int index = StringUtil.getMaxIndex("abcdefg");//6
        //测试用例
        int index2 = StringUtil.getMaxIndex("");
        int index3 = StringUtil.getMaxIndex(null);

        System.out.println(index);
        System.out.println(index2);
        System.out.println(index3);

        //做断言：断言结果是否与测试结果一致

        Assert.assertEquals("本轮测试失败，获取最大索引有问题，请检查",6,index);
        Assert.assertEquals("本轮测试失败，获取最大索引有问题，请检查",-1,index2);
        Assert.assertEquals("本轮测试失败，获取最大索引有问题，请检查",-1,index3);

    }
}
