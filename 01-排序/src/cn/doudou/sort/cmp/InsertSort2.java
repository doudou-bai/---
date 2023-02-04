package cn.doudou.sort.cmp;

import cn.doudou.sort.Sort;

/**
 * 插入排序 优化版一
 * Create By 王嘉浩
 * Time 2022-12-23 14:39
 */
public class InsertSort2<E extends Comparable<E>> extends Sort<E> {
    @Override
    protected void sort() {
        for (int begin = 0; begin < array.length; begin++) {
            int cur = begin;
            E e = array[cur];
            while (cur > 0 && cmp(e, array[cur - 1]) < 0) {
                array[cur] = array[cur - 1];
                cur--;
            }
            array[cur] = e;
        }
    }
}
