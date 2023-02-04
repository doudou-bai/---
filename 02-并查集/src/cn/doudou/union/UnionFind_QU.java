package cn.doudou.union;

/**
 * 合并快
 * Create By 王嘉浩
 * Time 2022-12-31 14:13
 */
public class UnionFind_QU extends UnionFind {
    /**
     * 构造方法
     *
     * @param capacity 传入的容量
     */
    public UnionFind_QU(int capacity) {
        super(capacity);
    }

    @Override
    public int find(int v) {
        rangeCheck(v);
        while (v != parents[v]) {
            v = parents[v];
        }
        return v;
    }

    @Override
    public void union(int v1, int v2) {
        int p1 = find(v1);
        int p2 = find(v2);
        if (p1 == p2) return;
        parents[p1] = p2;
    }
}
