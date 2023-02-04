package cn.doudou.sort;

/**
 * Create By 王嘉浩
 * Time 2022-12-27 22:46
 */
public class CountingSort extends Sort<Integer> {
    @Override
    protected void sort() {
        int max = max();
        int min = min();
        int[] counts = new int[max - min + 1];
        for (int i = 0; i < array.length; i++) {
            counts[array[i] - min]++;
        }
        //累加次数
        for (int i = 1; i < counts.length; i++) {
            counts[i] += counts[i - 1];
        }

        int[] newArray = new int[array.length];
        //从后向前进行遍历
        for (int i = array.length - 1; i >= 0; i--) {
            newArray[--counts[array[i] - min]] = array[i];
        }

        //覆盖数组
        for (int i = 0; i < newArray.length; i++) {
            array[i] = newArray[i];
        }
    }

    protected void sort1() {
        int max = max();
        //开辟空间,统计整数出现的位置
        int[] counts = new int[max + 1];
        for (int i = 0; i < array.length; i++) {
            counts[array[i]]++;
        }

        int index = 0;
        for (int i = 0; i < counts.length; i++) {
            while (counts[i]-- > 0) {
                array[index++] = i;
            }
        }
    }

    /**
     * 找出数组的最大值并返回
     *
     * @return int
     */
    private int max() {
        int max = array[0];
        for (Integer num : array) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }

    private int min() {
        int min = array[0];
        for (Integer num : array) {
            if (num < min) {
                min = num;
            }
        }
        return min;
    }
}