package cn.doudou.sort.cmp;

import cn.doudou.sort.Sort;

/**
 * 插入排序 初始版本
 * Create By 王嘉浩
 * Time 2022-12-23 14:39
 */
public class InsertSort<E extends Comparable<E>> extends Sort<E> {
    @Override
    protected void sort() {
        for (int begin = 0; begin < array.length; begin++) {
            int cur = begin;
            while (cur > 0 && cmp(cur, cur - 1) < 0) {
                swap(cur, cur - 1);
                cur--;
            }
        }
    }
}
