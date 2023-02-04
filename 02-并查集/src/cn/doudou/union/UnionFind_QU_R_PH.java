package cn.doudou.union;

/**
 * Quick Union -> 基于rank的优化 -> 路径减半
 * Create By 王嘉浩
 * Time 2023-01-01 14:23
 */
public class UnionFind_QU_R_PH extends UnionFind_QU {
    /**
     * 构造方法
     *
     * @param capacity 传入的容量
     */
    public UnionFind_QU_R_PH(int capacity) {
        super(capacity);
    }

    @Override
    public int find(int v) {
        rangeCheck(v);
        while (v != parents[v]) {
            parents[v] = parents[parents[v]];
            v = parents[v];
        }
        return v;
    }
}
