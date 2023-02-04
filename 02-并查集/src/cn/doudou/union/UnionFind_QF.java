package cn.doudou.union;

/**
 * 查找块
 * Create By 王嘉浩
 * Time 2022-12-31 14:10
 */
public class UnionFind_QF extends UnionFind {
    /**
     * 构造方法
     *
     * @param capacity 传入的容量
     */
    public UnionFind_QF(int capacity) {
        super(capacity);
    }


    /**
     * 查找v所属的集合
     *
     * @param v
     * @return
     */
    public int find(int v) {
        rangeCheck(v);
        return parents[v];
    }

    /**
     * 合并v1和v2集合
     *
     * @param v1
     * @param v2
     */
    public void union(int v1, int v2) {
        int p1 = find(v1);
        int p2 = find(v2);
        if (p1 == p2) return;

        for (int i = 0; i < parents.length; i++) {
            if (parents[i] == p1) {
                parents[i] = p2;
            }
        }

    }
}
