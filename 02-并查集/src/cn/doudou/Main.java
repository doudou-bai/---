package cn.doudou;

import cn.doudou.tools.Asserts;
import cn.doudou.tools.Times;
import cn.doudou.union.*;

/**
 * Create By 王嘉浩
 * Time 2022-12-31 13:25
 */
public class Main {
    static final int count = 1000000;

    public static void main(String[] args) {

//        testTime(new UnionFind_QU(count));
//        testTime(new UnionFind_QF(count));
/*        testTime(new UnionFind_QU_S(count));
        testTime(new UnionFind_QU_R(count));*/
        testTime(new UnionFind_QU_R_PC(count));
        testTime(new UnionFind_QU_R_PS(count));
        testTime(new UnionFind_QU_R_PH(count));
        testTime(new GenericUnionFind<Integer>());

//        GenericUnionFind<Student> uf = new GenericUnionFind<>();
//
//        Student s1 = new Student(1, "jack");
//        Student s2 = new Student(2, "rose");
//        Student s3 = new Student(3, "jack");
//        Student s4 = new Student(4, "rose");
//
//        uf.makeSet(s1);
//        uf.makeSet(s2);
//        uf.makeSet(s3);
//        uf.makeSet(s4);
//
//        uf.union(s1, s2);
//        uf.union(s3, s4);
//        uf.union(s2, s4);


//        Asserts.test(uf.isSame(s1,s2));
//        Asserts.test(uf.isSame(s3,s4));
//        Asserts.test(uf.isSame(s1,s4));


    }

    static void testTime(GenericUnionFind<Integer> uf) {
        for (int i = 0; i < count; i++) {
            uf.makeSet(i);
        }

        uf.union(0, 1);
        uf.union(0, 3);
        uf.union(0, 4);
        uf.union(2, 3);
        uf.union(2, 5);

        uf.union(6, 7);

        uf.union(8, 10);
        uf.union(9, 10);
        uf.union(9, 11);

        Asserts.test(!uf.isSame(2, 7));

        uf.union(4, 6);

        Asserts.test(uf.isSame(2, 7));

        Times.test(uf.getClass().getSimpleName(), () -> {
            for (int i = 0; i < count; i++) {
                uf.union((int)(Math.random() * count),
                        (int)(Math.random() * count));
            }

            for (int i = 0; i < count; i++) {
                uf.isSame((int)(Math.random() * count),
                        (int)(Math.random() * count));
            }
        });
    }

    static void testTime(UnionFind uf) {
        uf.union(0, 1);
        uf.union(0, 3);
        uf.union(0, 4);
        uf.union(2, 3);
        uf.union(2, 5);

        uf.union(6, 7);

        uf.union(8, 10);
        uf.union(9, 10);
        uf.union(9, 11);

        Asserts.test(!uf.isSame(2, 7));
        uf.union(4, 6);
        Asserts.test(uf.isSame(2, 7));

        Times.test(uf.getClass().getSimpleName(), () -> {
            for (int i = 0; i < count; i++) {
                uf.union((int)(Math.random() * count),
                        (int)(Math.random() * count));
            }

            for (int i = 0; i < count; i++) {
                uf.isSame((int)(Math.random() * count),
                        (int)(Math.random() * count));
            }
        });
    }
}
