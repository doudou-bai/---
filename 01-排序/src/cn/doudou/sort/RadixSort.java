package cn.doudou.sort;

/**
 * Create By 王嘉浩
 * Time 2022-12-30 14:23
 */
public class RadixSort extends Sort<Integer> {
    @Override
    protected void sort() {

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

    /**
     * 找出数组的最小值并返回
     * @return int
     */
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
