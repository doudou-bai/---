package cn.doudou.sort.cmp;

import cn.doudou.sort.Sort;

/**
 * 冒泡排序 优化二
 * Create By 王嘉浩
 * Time 2022-12-20 23:12
 */
public class BubbleSort2<E extends Comparable<E>> extends Sort<E> {
    @Override
    protected void sort() {
        for (int end = array.length - 1; end > 0; end--) {
            //定义一个sorted值
            boolean sorted = true;
            for (int begin = 1; begin <= end; begin++) {
                if (cmp(begin, begin - 1) < 0) {//如果进行了交换就修改下sorted的值为true
                    swap(begin, begin - 1);
                    sorted = false;
                }
            }
            //判断sorted的值为true的时候代表他没有执行交换的代码 就可以直接跳出 执行下一次 循环
            if (sorted) break;
        }
    }
}
