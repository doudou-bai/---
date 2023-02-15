package cn.doudou;

/**
 * Create By 王嘉浩
 * Time 2023-02-13 20:55
 */
public class Climbstairs {
    public static void main(String[] args) {
        System.out.println(climbstairs2(45));
    }

    static int climbstairs(int n) {
        if (n <= 2) {
            return n;
        }
        return climbstairs(n - 1) + climbstairs(n - 2);
    }

    /**
     * 优化1
     *
     * @param n
     * @return
     */
    static int climbstairs2(int n) {
        if (n <= 2) {
            return n;
        }
        int first = 1;
        int second = 2;
        for (int i = 3; i <= n; i++) {
            second = first + second;
            first = second - first;
        }
        return second;
    }
}
