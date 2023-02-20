package cn.doudou;

import com.sun.media.sound.RIFFInvalidDataException;

/**
 * Create By 王嘉浩
 * Time 2023-02-16 15:06
 */
public class Queens2 {
    public static void main(String[] args) {
        new Queens2().placeQueens(4);
    }

    // cols[row] = col; 表示第row行第col列摆放了皇后
    boolean cols[];
    //左上角->右下角
    boolean leftTop[];
    //右上角->左下角
    boolean rightTop[];
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
        cols = new boolean[n];
        leftTop = new boolean[(n << 1) - 1];
        rightTop = new boolean[leftTop.length];
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
            if (cols[col]) continue;
            //计算leftTop 的索引位置
            int ltIndex = row - col + cols.length - 1;
            //根据计算出来leftTop的索引位置查看该行是不是已经摆放皇后
            if (leftTop[ltIndex]) continue;
            //计算rightTop索引位置
            int rtIndex = row + col;
            //根据计算出来rightTop的索引位置查看该行是不是已经摆放皇后
            if (rightTop[rtIndex]) continue;
            //如果可以摆放就把循环的值赋值
            cols[col] = leftTop[ltIndex] = rightTop[rtIndex] = true;
            //然后在进行递归 row+1
            place(row + 1);

            cols[col] = leftTop[ltIndex] = rightTop[rtIndex] = false;
        }

    }

    /**
     * N皇后的打印
     */
    void show() {
       /* for (int row = 0; row < cols.length; row++) {
            for (int col = 0; col < cols.length; col++) {
                if (cols[row]) { // 摆放了皇后
                    System.out.print("Q");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
        System.out.println("--------------------------");*/
    }

}
