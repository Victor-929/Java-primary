package com.itheima.demo4test;

import java.util.*;

public class Room {
    //1、准备好54张牌，给房间使用：定义一个集合容器装54张牌
    private List<Card> allcards = new ArrayList<>();
    //2、初始化54张牌进去
    {
        //3、准备点数
        String[] sizes = {"3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A", "2"};
        //4、准备花色
        String[] colors = {"红桃", "黑桃", "梅花", "方块"};
        //5、组合点数和花色，得到54张牌
        int num = 0;
        for (String size : sizes) {
            num++;
            for (String color : colors) {
                //6、创建一张牌,加入到集合中
                allcards.add(new Card(size, color,num));
            }
        }
//        allcards.add(new Card("", "小王"));
//        allcards.add(new Card("", "大王"));
        Collections.addAll(allcards, new Card("", "小王",++num), new Card("", "大王",++num));
        System.out.println("新牌是：" + allcards);
    }
    public void start() {
        //7、洗牌，打乱集合中牌的顺序
        Collections.shuffle(allcards);
        System.out.println("洗牌后：" + allcards);

        //8、发牌，将54张牌分成3个玩家，17张，17张，17张，3张
        Map<String, List<Card>> players = new HashMap<>();
        List<Card> lhc = new ArrayList<>();
        players.put("令狐冲", lhc);

        List<Card> lhb = new ArrayList<>();
        players.put("令狐白", lhb);

        List<Card> lhz = new ArrayList<>();
        players.put("令狐紫", lhz);
        
        //allCards = [
        //只发出51张，
        for (int i = 0; i < allcards.size()-3; i++) {
            //获取到当前遍历的牌
            Card card = allcards.get(i);
            //判断当前这张牌发给谁
            if (i % 3 == 0) {
                //给令狐冲
                lhc.add(card);
            } else if (i % 3 == 1) {
                //给令狐白
                lhb.add(card);
            } else if (i % 3 == 2){
                //给令狐紫
                lhz.add(card);
            }
        }
        //9、对牌排序
        //11、拿最后三张牌
        List<Card> lastCards = allcards.subList(allcards.size()-3, allcards.size());
        System.out.println("最后三张牌是：" + lastCards);

        //抢地主，把这个集合直接倒给玩家
        lhz.addAll(lastCards);

        //9、对牌排序
        sortCards(lhc);
        sortCards(lhb);
        sortCards(lhz);


        //10、看牌，遍历Map集合
        for (Map.Entry<String, List<Card>> entry : players.entrySet()) {
            //获取到玩家的名字
            String name = entry.getKey();
            //获取到玩家的牌
            List<Card> cards = entry.getValue();
            //看牌
            System.out.println(name + "的牌是：" + cards);
        }

    }
    public void sortCards(List<Card> cards) {
        Collections.sort(cards, new Comparator<Card>() {
            @Override
            public int compare(Card o1, Card o2) {
                return o2.getNum()-o1.getNum();
            }

        });
    }
}
