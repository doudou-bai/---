package cn.doudou;

import java.util.Arrays;

/**
 * Create By 王嘉浩
 * Time 2023-02-21 17:17
 */
public class Pirate {
    public static void main(String[] args) {
        int[] weights = {3, 5, 4, 10, 7, 14, 2, 11};
        //让数组有序
        Arrays.sort(weights);
        //初始化容量 和数量
        int capacity = 30, weight = 0, count = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < weights.length && weight < capacity; i++) {
            int newWeight = weight + weights[i];
            if (newWeight <= capacity) {
                weight = newWeight;
                count++;
                sb.append(weights[i] + ", ");
            }
        }
        System.out.println(sb.deleteCharAt(sb.lastIndexOf(",")));
        System.out.println("一共可以装载" + count + "件古董！");
    }
}
