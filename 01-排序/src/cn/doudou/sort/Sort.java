package cn.doudou.sort;

import cn.doudou.Student;
import cn.doudou.sort.cmp.ShellSort;

import java.text.DecimalFormat;

public abstract class Sort<E extends Comparable<E>> implements Comparable<Sort<E>> {
    protected E[] array;
    private int cmpConut;
    private int swapConut;
    private long time;
    private DecimalFormat fmt = new DecimalFormat("#.00");

    public void sort(E[] array) {
        if (array == null || array.length < 2)
            return;
        this.array = array;

        long begin = System.currentTimeMillis();
        sort();
        time = System.currentTimeMillis() - begin;
    }

    protected abstract void sort();

    @Override
    public int compareTo(Sort<E> o) {
        int result = (int) (time - o.time);
        if (result != 0) return result;
        result = cmpConut - o.cmpConut;
        if (result != 0) return result;
        return swapConut - o.swapConut;
    }

    /**
     * 返回值等于0 两个数相等 返回值大于0 i1大 返回值小于0 i2大
     *
     * @param i1
     * @param i2
     * @return int
     */
    protected int cmp(int i1, int i2) {
        // 计算比较的次数
        cmpConut++;
        return array[i1].compareTo(array[i2]);
    }


    protected int cmp(E e1, E e2) {
        // 计算比较的次数
        cmpConut++;
        return e1.compareTo(e2);
    }

    /**
     * 传入两个数交换两个数的位置
     *
     * @param i1
     * @param i2
     */
    protected void swap(int i1, int i2) {
        // 计算交换的次数
        swapConut++;
        E tmp = array[i1];
        array[i1] = array[i2];
        array[i2] = tmp;
    }

    @Override
    public String toString() {
        String timeStr = "耗时：" + (time / 1000.0) + "s(" + time + "ms)";
        String compareCountStr = "比较：" + numberString(cmpConut);
        String swapCountStr = "交换：" + numberString(swapConut);
        String stableStr = "稳定性：" + isStable();
        return "【" + getClass().getSimpleName() + "】\n"
                + stableStr + " \t"
                + timeStr + " \t"
                + compareCountStr + "\t "
                + swapCountStr + "\n"
                + "------------------------------------------------------------------";
    }

    private boolean isStable() {
        if (this instanceof ShellSort)return false;
        if (this instanceof CountingSort)return false;
        Student[] students = new Student[20];
        for (int i = 0; i < students.length; i++) {
            students[i] = new Student(i * 10, 10);
        }
        sort((E[]) students);
        for (int i = 1; i < students.length; i++) {
            int score = students[i].score;
            int prevScore = students[i - 1].score;
            if (score != prevScore + 10) return false;
        }
        return true;
    }

    private String numberString(int number) {
        if (number < 10000) return "" + number;

        if (number < 100000000) return fmt.format(number / 10000.0) + "万";
        return fmt.format(number / 100000000.0) + "亿";
    }
}
