package cn.doudou;

/**
 * Create By 王嘉浩
 * Time 2023-02-13 21:16
 */
public class Hanoi {
    public static void main(String[] args) {
        hanoi(5, "A", "B", "C");
    }

    /**
     * @param n
     * @param p1 柱子A
     * @param p2 柱子B
     * @param p3 柱子C
     */
    static void hanoi(int n, String p1, String p2, String p3) {
        if (n <= 1) {
            move(n, p1, p3);
            return;
        }
        //p1  --- > p3
        hanoi(n - 1, p1, p3, p2);
        move(n, p1, p3);
        //p2  --- > p3
        hanoi(n - 1, p2, p1, p3);

    }

    static void move(int i, String from, String to) {
        System.out.println(i + "号盘子:" + from + "-->" + to);
    }
}
