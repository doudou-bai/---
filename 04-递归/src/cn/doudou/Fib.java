package cn.doudou;

import cn.doudou.tools.Times;

import java.util.HashMap;
import java.util.Map;

/**
 * Create By 王嘉浩
 * Time 2023-02-07 14:10
 */
public class Fib {
    public static void main(String[] args) {
        Times.test("fib0", () -> {
            System.out.println(fib0(40));
        });

        Times.test("fib1", () -> {
            System.out.println(fib1(40));

        });

        Times.test("fib2", () -> {
            System.out.println(fib2(40));

        });

        Times.test("fib3", () -> {
            System.out.println(fib3(40));

        });

        Times.test("fib4", () -> {
            System.out.println(fib3(55));

        });
        Times.test("fib5", () -> {
            System.out.println(fib5(55));

        });
    }

    /**
     * 未优化
     *
     * @param n
     * @return
     */
    static int fib0(int n) {
        if (n <= 2) {
            return 1;
        }
        return fib0(n - 1) + fib0(n - 2);
    }

    /**
     * 数组的优化策略
     *
     * @param n
     * @return
     */
    static int fib1(int n) {
        if (n <= 2) {
            return 1;
        }
        int[] array = new int[n + 1];
        array[1] = array[2] = 1;
        return fib1(n, array);
    }

    static int fib1(int n, int[] array) {
        if (array[n] == 0) {
            array[n] = fib1(n - 1, array) + fib1(n - 2, array);
        }
        return array[n];
    }

    /**
     * 自想的优化策略  和数组一样
     *
     * @param n
     * @return
     */
    static int fib2(int n) {
        if (n <= 2) {
            return 1;
        }
        Map<Integer, Integer> map = new HashMap<>();
        map.put(1, 1);
        map.put(2, 1);
        return fib2(n, map);
    }

    static int fib2(int n, Map<Integer, Integer> map) {
        if (map.get(n) == null) {
            map.put(n, fib2(n - 1, map) + fib2(n - 2, map));
        }
        return map.get(n);
    }

    /**
     * 去除递归调用
     *
     * @param n
     * @return
     */
    static int fib3(int n) {
        if (n <= 2) {
            return 1;
        }
        int[] array = new int[n + 1];
        array[1] = array[2] = 1;
        for (int i = 3; i <= n; i++) {
            array[i] = array[i - 1] + array[i - 2];
        }
        return array[n];
    }

    /**
     * 滚动数组实现过程
     *
     * @param n
     * @return
     */
    static int fib4(int n) {
        if (n <= 2) {
            return 1;
        }
        int[] array = new int[2];
        array[1] = array[2] = 1;
        for (int i = 3; i <= n; i++) {
            array[i % 2] = array[(i - 1) % 2] + array[(i - 2) % 2];
        }
        return array[n % 2];
    }

    /**
     * % 2 优化为 & 1
     *
     * @param n
     * @return
     */
    static int fib5(int n) {
        if (n <= 2) {
            return 1;
        }
        int[] array = new int[2];
        array[1] = array[0] = 1;
        for (int i = 3; i <= n; i++) {
            array[i & 1] = array[(i - 1) & 1] + array[(i - 2) & 1];
        }
        return array[n & 1];
    }
}
