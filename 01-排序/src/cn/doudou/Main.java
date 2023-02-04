package cn.doudou;

import cn.doudou.sort.*;
import cn.doudou.sort.cmp.BubbleSort3;
import cn.doudou.sort.cmp.ShellSort;
import cn.doudou.tools.Asserts;
import cn.doudou.tools.Integers;

import java.util.Arrays;


@SuppressWarnings({"rawtypes", "unchecked"})
public class Main {
    public static void main(String[] args) {
        /*
         * Integer[] array1 = Integers.tailAscOrder(1, 50000, 1000); Integer[] array2 =
         * Integers.copy(array1); Integer[] array3 = Integers.copy(array1);
         *
         *
         * Times.test("bubbleSort1", () -> { bubbleSort1(array1); });
         *
         * Times.test("bubbleSort2", () -> { bubbleSort2(array2); });
         *
         * Times.test("bubbleSort3", () -> { bubbleSort3(array3); });
         */

     /*   Integer[] array = Integers.random(10000, 1, 20000);
        Times.test("selectionSort1", () -> {
            selectionSort1(array);
        });

        Asserts.test(Integers.isAscOrder(array) == true);*/

        tset1();
      /*  int[] array = {2, 4, 8, 8, 8, 12, 14};
        Asserts.test(BinarySearch.search(array, 5) == 2);
        Asserts.test(BinarySearch.search(array, 1) == 0);
        Asserts.test(BinarySearch.search(array, 15) == 7);
        Asserts.test(BinarySearch.search(array, 8) == 5);*/
    }

    /**
     * 三个版本的对比
     */
    static void tset1() {
        //Integer[] array = Integers.random(10000, 0, 100000);
         Integer[] array = {7, 3, 5, 8, 6, 7, 4, 5};
        testSort(array,
                //new BubbleSort3(),
                //new SelectionSort(),
                //new InsertSort(),
                //new InsertSort2(),
                //new InsertSort3(),
                //new QuickSort(),
                //new MergeSort(),
                //new HeapSort(),
                //new ShellSort(),
                new CountingSort()
        );

    }

    static void testSort(Integer[] array, Sort... sorts) {
        for (Sort sort : sorts) {
            Integer[] newArray = Integers.copy(array);
            sort.sort(newArray);
            Asserts.test(Integers.isAscOrder(newArray));
        }

        Arrays.sort(sorts);

        for (Sort sort : sorts) {
            System.out.println(sort);
        }

    }

    /**
     * 未优化冒泡排序
     *
     * @param array
     */
    static void bubbleSort1(Integer[] array) {
        for (int end = array.length - 1; end > 0; end--) {
            for (int begin = 1; begin <= end; begin++) {
                if (array[begin] < array[begin - 1]) {
                    int tmp = array[begin];
                    array[begin] = array[begin - 1];
                    array[begin - 1] = tmp;
                }
            }
        }
    }

    /**
     * 冒泡排序-优化版本一
     *
     * @param array
     */
    static void bubbleSort2(Integer[] array) {
        for (int end = array.length - 1; end > 0; end--) {
            boolean sorted = true;
            for (int begin = 1; begin <= end; begin++) {
                if (array[begin] < array[begin - 1]) {
                    int tmp = array[begin];
                    array[begin] = array[begin - 1];
                    array[begin - 1] = tmp;
                    sorted = false;
                }
            }
            if (sorted)
                break;
        }
    }

    /**
     * 冒泡排序-优化版本二
     *
     * @param array
     */
    static void bubbleSort3(Integer[] array) {
        for (int end = array.length - 1; end > 0; end--) {
            int sortedIndex = 1;
            for (int begin = 1; begin <= end; begin++) {
                if (array[begin] < array[begin - 1]) {
                    int tmp = array[begin];
                    array[begin] = array[begin - 1];
                    array[begin - 1] = tmp;
                    sortedIndex = begin;
                }
            }
            end = sortedIndex;
        }
    }

    /**
     * 选择排序
     *
     * @param array
     */
    static void selectionSort1(Integer[] array) {
        for (int end = array.length - 1; end > 0; end--) {
            int maxIndex = 0;
            for (int begin = 1; begin <= end; begin++) {
                if (array[maxIndex] <= array[begin]) {
                    maxIndex = begin;
                }
            }
            int tmp = array[maxIndex];
            array[maxIndex] = array[end];
            array[end] = tmp;
        }
    }

}
