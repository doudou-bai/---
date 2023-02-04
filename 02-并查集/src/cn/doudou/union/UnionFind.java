package cn.doudou.union;

/**
 * Create By 王嘉浩
 * Time 2022-12-31 13:26
 */
public abstract class UnionFind {
    protected int[] parents;

    /**
     * 构造方法
     *
     * @param capacity 传入的容量
     */
    public UnionFind(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException("容量不能小于1!!!");
        }

        parents = new int[capacity];
        for (int i = 0; i < parents.length; i++) {
            parents[i] = i;
        }
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

    /**
     * 检查v1和v2是否属于同一个集合
     *
     * @param v1
     * @param v2
     * @return
     */
    public boolean isSame(int v1, int v2) {
        return find(v1) == find(v2);
    }

    protected void rangeCheck(int v) {
        if (v < 0 || v >= parents.length) {
            throw new IllegalArgumentException("数组越界!!!");
        }
    }
}
