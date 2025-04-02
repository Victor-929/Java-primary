package com.itheima.demo8test;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MovieService {
    //4、准备一个集合容器：存储全部上架的电影数据
    private static List<Movie> movies = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    public void start() {
        while (true) {
            //3、准备操作界面:GUI界面/cmd命令做。
            System.out.println("====欢迎来到电影管理系统===");
            System.out.println("1、上架");
            System.out.println("2、下架某个电影");
            System.out.println("3、查询某个电影");
            System.out.println("4、封杀某个明星");
            System.out.println("5、退出");
            System.out.println("6、展示全部电影");
            System.out.println("7、修改某个电影");
            System.out.println("请您输入操作命令：");
            String command = sc.next();
            switch (command) {
                case "1":
                    //上架(独立功能独立成方法)
                    addMovice();
                    break;
                case "2":
                    //下架某个电影
                    break;
                case "3":
                    //查询某个电影
                    querryMovice();
                    break;
                case "4":
                    //封杀某个明星
                    deleteStarter();
                    break;
                case "5":
                    //退出
                    System.out.println("感谢您的使用，欢迎下次再来！");
                    return;
                case "6":
                    //展示全部电影
                    queryAllMovie();
                    break;
                case "7":
                    //修改某个电影
                    break;
                default:
                    System.out.println("您输入的命令有误，请重新输入！");
            }
        }

    }

    /**
     * 展示全部电影
     */
    private void queryAllMovie() {
        System.out.println("---------展示全部电影----------");
        for (Movie movie : movies) {
            System.out.println(movie);
        }
    }

    /**
     * 封杀某个明星
     */
    private void deleteStarter() {
        System.out.println("---------封杀明星----------");
        System.out.println("请您输入明星名称：");
        String actor = sc.next();
        for (int i = 0; i < movies.size(); i++) {
            Movie movie = movies.get(i);
            if (movie.getActor().contains(actor)) {
                movies.remove(movie);
                System.out.println("封杀成功！");
                i--;//退一步
            }
        }
        //展示全部电影
        queryAllMovie();
    }

    /**
     * 根据电影名称查询电影对象返回，展示这个对象数据
     */
    private void querryMovice() {
        System.out.println("---------查询电影----------");
        System.out.println("请您输入电影名称：");
        String name = sc.next();
        Movie movie = queryMovieByName(name);
        if (movie == null) {
            System.out.println("没有找到您要查询的电影！");
        } else {
            System.out.println("您要查询的电影是：" + movie);
        }

    }

    //根据电影名称查询电影对象返回
    //movices = [m1,m2,m3,m4]
    public Movie queryMovieByName(String name) {
        for (Movie movie : movies) {
            if (movie.getName().equals(name)) {
                return movie;//找到了
            }
        }
        return null;//没找到
    }

    /**
     * 上架电影
     */
    private void addMovice() {
        System.out.println("---------上架电影----------");
        //分析：每点击一次上架电影，其实就是新增一部电影，每部电影是一个电影对象封装数据的
        //1、创建电影对象，封装这部电影信息。
        Movie movie = new Movie();
        //2、给电影对象注入数据
        System.out.println("请您输入电影名称：");
        movie.setName(sc.next());
        System.out.println("请您输入电影评分：");
        movie.setScore(sc.nextDouble());
        System.out.println("请您输入电影演员：");
        movie.setActor(sc.next());
        System.out.println("请您输入电影价格：");
        movie.setPrice(sc.nextDouble());
        //3、把电影对象放入集合中。
        movies.add(movie);
        //4、提示用户上架成功。
        System.out.println("上架成功！");
    }
}
