package cn.doudou.sort.cmp;

import cn.doudou.sort.Sort;

/**
 * 插入排序 优化版二
 * Create By 王嘉浩
 * Time 2022-12-23 14:39
 */
public class InsertSort3<E extends Comparable<E>> extends Sort<E> {
    @Override
    protected void sort() {
        for (int begin = 0; begin < array.length; begin++) {
            insert(begin, search(begin));
        }
    }

    /**
     * 将source位置的元素插入到dest位置上面
     *
     * @param source
     * @param dest
     */
    private void insert(int source, int dest) {
        E e = array[source];
        for (int i = source; i > dest; i--) {
            array[i] = array[i - 1];
        }
        array[dest] = e;
    }

    /**
     * 使用二分搜索找到index位置元素的待插入位置
     *
     * @param index
     * @return
     */
    private int search(int index) {
        int begin = 0;
        int end = index;
        while (begin < end) {
            int mid = (begin + end) >> 1;
            if (cmp(array[index], array[mid]) < 0) {
                end = mid;
            } else {
                begin = mid + 1;
            }
        }
        return begin;
    }
}
