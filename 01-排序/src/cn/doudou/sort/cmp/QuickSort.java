package cn.doudou.sort.cmp;

import cn.doudou.sort.Sort;

/**
 * Create By 王嘉浩
 * Time 2022-12-25 22:27
 */
public class QuickSort<E extends Comparable<E>> extends Sort<E> {
    @Override
    protected void sort() {
        sort(0, array.length);
    }

    /**
     * 对[begin,end)范围的元素进行快速排序
     *
     * @param begin
     * @param end
     */
    private void sort(int begin, int end) {
        if (end - begin < 2) return;

        //确定轴的位置
        int mid = pivotIndex(begin, end);

        //对子序列进行快速排序
        sort(begin, mid);
        sort(mid + 1, end);

    }

    /**
     * 构造出[begin,end)范围的轴点元素
     *
     * @param begin
     * @param end
     * @return
     */
    private int pivotIndex(int begin, int end) {
        //随机找一个元素和begin进行交换位置
        swap(begin, begin + (int) Math.random() * (end - begin));

        //备份轴点位置的元素
        E pivot = array[begin];
        //让end指向最后一个元素
        end--;

        while (begin < end) {
            while (begin < end) {
                if (cmp(pivot, array[end]) < 0) {//右边元素 < 轴点元素
                    end--;
                } else {//右边元素 > 轴点元素
                    array[begin++] = array[end];
                    //只要执行else就调换方向
                    break;
                }
            }

            while (begin < end) {
                if (cmp(pivot, array[begin]) > 0) {//左边元素 < 轴点元素
                    begin++;
                } else {//左边元素 >= 轴点元素
                    array[end--] = array[begin];
                    break;
                }
            }
        }
        //将轴点元素插入到最后确定的位置
        array[begin] = pivot;
        return begin;
    }
}
