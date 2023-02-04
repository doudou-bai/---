package cn.doudou.union;

/**
 * Quick Union - 基于size的优化
 * 可能会导致树的 不平衡 最好选用基于树的高度进行的优化
 * <p>
 * Create By 王嘉浩
 * Time 2023-01-01 13:42
 */
public class UnionFind_QU_S extends UnionFind_QU {
    private int[] sizes;

    /**
     * 构造方法
     *
     * @param capacity 传入的容量
     */
    public UnionFind_QU_S(int capacity) {
        super(capacity);

        sizes = new int[capacity];
        for (int i = 0; i < capacity; i++) {
            sizes[i] = 1;
        }
    }


    @Override
    public void union(int v1, int v2) {
        int p1 = find(v1);
        int p2 = find(v2);
        if (p1 == p2) return;

        if (parents[p1] < parents[p2]) {
            parents[p1] = p2;
            sizes[p2] += sizes[p1];
        } else {
            parents[p2] = p1;
            sizes[p1] += sizes[p2];
        }
    }
}
