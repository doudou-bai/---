package cn.doudou.ks;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

/**
 * Create By 王嘉浩
 * Time 2023-02-23 11:24
 * 0-1背包
 */
public class Knapsack {
    public static void main(String[] args) {
        //价值主导
        select("价值主导", (Article a1, Article a2) -> {
            return a2.value - a1.value;
        });

        //重量主导
        select("重量主导", (Article a1, Article a2) -> {
            return a1.weight - a2.weight;
        });

        //价值密度主导
        select("价值主导", (Article a1, Article a2) -> {
            return Double.compare(a2.valueDensity, a1.valueDensity);
        });

    }

    static void select(String title, Comparator<Article> cmp) {
        // 模拟题意的物品
        Article[] articles = new Article[]{
                new Article(35, 10),
                new Article(30, 40),
                new Article(60, 30),
                new Article(50, 50),
                new Article(40, 35),
                new Article(10, 40),
                new Article(25, 30)
        };
        Arrays.sort(articles, cmp);

        int capacity = 150, weight = 0, value = 0;
        LinkedList<Article> selectArticles = new LinkedList<>();

        for (int i = 0; i < articles.length && weight < capacity; i++) {
            int newWeight = weight + articles[i].weight;
            if (newWeight <= capacity) {
                weight = newWeight;
                value += articles[i].value;
                selectArticles.add(articles[i]);
            }
        }
        System.out.println("[" + title + "]");
        System.out.println("总价值:" + value);
        for (int i = 0; i < selectArticles.size(); i++) {
            System.out.println(selectArticles.get(i));
        }
        System.out.println("--------------------------");
    }
}
