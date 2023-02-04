package cn.doudou.union;

/**
 * Quick Union -> 基于rank的优化 -> 路径压缩
 * Create By 王嘉浩
 * Time 2023-01-01 14:23
 */
public class UnionFind_QU_R_PC extends UnionFind_QU_R {
    /**
     * 构造方法
     *
     * @param capacity 传入的容量
     */
    public UnionFind_QU_R_PC(int capacity) {
        super(capacity);
    }

    @Override
    public int find(int v) {
        rangeCheck(v);
        if (parents[v] != v) {
            parents[v] = find(parents[v]);
        }
        return parents[v];
    }
}
