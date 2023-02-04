package cn.doudou.union;

/**
 * Quick Union -> 基于rank的优化 -> 路径分裂
 * Create By 王嘉浩
 * Time 2023-01-01 14:23
 */
public class UnionFind_QU_R_PS extends UnionFind_QU {
    /**
     * 构造方法
     *
     * @param capacity 传入的容量
     */
    public UnionFind_QU_R_PS(int capacity) {
        super(capacity);
    }

    @Override
    public int find(int v) {
        rangeCheck(v);
        while (v != parents[v]) {
            int p = parents[v];
            parents[v] = parents[parents[v]];
            v = p;
        }
        return v;
    }
}
