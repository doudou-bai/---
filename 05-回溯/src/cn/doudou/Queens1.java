package cn.doudou;

/**
 * Create By 王嘉浩
 * Time 2023-02-16 15:06
 */
public class Queens1 {
    public static void main(String[] args) {
        new Queens1().placeQueens(8);
    }

    // cols[row] = col; 表示第row行第col列摆放了皇后
    int cols[];
    // 一共有多少种合理的摆法
    int ways = 0;

    /**
     * N皇后
     *
     * @param n
     */
    void placeQueens(int n) {
        //判断n必须大于1
        if (n < 1) return;
        //设置row的值
        cols = new int[n];
        //调摆放皇后的方法
        place(0);
        System.out.println(n + "皇后一共有" + ways + "种摆法");
    }

    /**
     * 从第row行开始进行摆皇后
     *
     * @param row
     */
    void place(int row) {
        //如果已经放到了第n行,就说明我们找到了一种摆法
        if (row == cols.length) {
            //统计摆法
            ways++;
            //打印
            show();
            //结束主程序
            return;
        }

        //循环进行查找 0-0 0-1 0-2
        for (int col = 0; col < cols.length; col++) {
            //判断是否可以摆放
            if (isValid(row, col)) {
                //如果可以摆放就把循环的值赋值
                cols[row] = col;
                //然后在进行递归 row+1
                place(row + 1);
            }
        }

    }

    /**
     * 判断第row行第col列是否可以摆放皇后
     *
     * @param row 行
     * @param col 列
     * @return
     */
    boolean isValid(int row, int col) {
        for (int i = 0; i < row; i++) {
            //判断第col列上面是不是已经有了一个皇后
            if (cols[i] == col) {//已经有了一个皇后
                //System.out.println("[" + row + "][" + col + "]=false");
                return false;
            }

            //处理斜对角的皇后  上左 -> 下右  || 上右 --> 下左
            //第i行的皇后根第row行第col列格子处在同一斜线上
            // 45度角斜线: y-y0 = (x-x0), 则 (y-y0)/(x-x0) = 1, 表示为45度角的斜线
            if (row - i == Math.abs(col - cols[i])) {
                // System.out.println("[" + row + "][" + col + "]=false");
                return false;
            }
        }
        //System.out.println("[" + row + "][" + col + "]=true");
        return true;
    }

    /**
     * N皇后的打印
     */
    void show() {
        for (int row = 0; row < cols.length; row++) {
            for (int col = 0; col < cols.length; col++) {
                if (cols[row] == col) { // 摆放了皇后
                    System.out.print("Q");
                } else {
                    System.out.print(".");
                }
            }
            System.out.println();
        }
        System.out.println("--------------------------");
    }

}
