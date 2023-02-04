package cn.doudou.sort.cmp;

import cn.doudou.sort.Sort;

/**
 * 堆排序的实现
 *
 * @param <E>
 */
public class HeapSort<E extends Comparable<E>> extends Sort<E> {
    private int heapSize;

    @Override
    protected void sort() {
        heapSize = array.length;
        for (int i = ((heapSize >> 1) - 1); i >= 0; i--) {
            siftDown(i);
        }

        while (heapSize > 1) {
            swap(0, --heapSize);
            siftDown(0);
        }
    }

    private void siftDown(int index) {
        E e = array[index];
        int half = heapSize >> 1;
        while (index < half) {
            int chindIndex = (index << 1) + 1;
            E chind = array[chindIndex];

            int rightIndex = chindIndex + 1;
            if (rightIndex < heapSize && cmp(array[rightIndex], chind) > 0) {
                chind = array[chindIndex = rightIndex];
            }
            if (cmp(e, chind) >= 0) break;
            array[index] = chind;
            index = chindIndex;
        }
        array[index] = e;
    }

    protected int compare(Integer e1, Integer e2) {
        return e1 - e2;
    }

}
