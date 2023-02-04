package cn.doudou.sort.cmp;

import cn.doudou.sort.Sort;

/**
 * 冒泡排序 优化三
 * Create By 王嘉浩
 * Time 2022-12-20 23:12
 */
public class BubbleSort3<E extends Comparable<E>> extends Sort<E> {
    @Override
    protected void sort() {
        for (int end = array.length - 1; end > 0; end--) {
            //定义一个变量备份一下begin元素地 索引位置
            int sortedIndex = 1;
            for (int begin = 1; begin <= end; begin++) {
                if (cmp(begin, begin - 1) < 0) {//如果进行了交换 就把元素的索引位置赋值给sortedIndex
                    swap(begin, begin - 1);
                    sortedIndex = begin;
                }
            }
            end = sortedIndex;
        }
    }
}
