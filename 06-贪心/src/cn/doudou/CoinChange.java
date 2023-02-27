package cn.doudou;

import java.util.Arrays;

/**
 * Create By 王嘉浩
 * Time 2023-02-21 17:34
 */
public class CoinChange {
    public static void main(String[] args) {
        Integer[] faces = {1, 5, 10, 25};
        //定义找回的零钱
        int money = 43, coins = 0, i = 0;
        //数组排序
        Arrays.sort(faces, (Integer f1, Integer f2) -> f2 - f1);

        while (i < faces.length) {
            if (money < faces[i]) {//当前钱小于要找回最大的面额
                //移动指针
                i++;
                continue;
            }
            System.out.print(faces[i] + " ");
            money -= faces[i];
            coins++;
        }
        System.out.println();
        System.out.println("一共需要" + coins + "硬币!");
    }
}
