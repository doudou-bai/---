package cn.doudou.sort.cmp;

import cn.doudou.sort.Sort;

/**
 * 冒泡排序 初始版
 * Create By 王嘉浩
 * Time 2022-12-20 23:12
 */
public class BubbleSort1<E extends Comparable<E>> extends Sort<E> {
    @Override
    protected void sort() {
        //从数组的最后一个开始
        for (int end = array.length - 1; end > 0; end--) {
            //从数组的头元素+1进行开始循环
            for (int begin = 1; begin <= end; begin++) {
                //每次循环找到begin的位置和begin-1的位置进行比较
                if (cmp(begin, begin - 1) < 0) {
                    //交换2个元素的位置
                    swap(begin, begin - 1);
                }
            }
        }
    }
}
