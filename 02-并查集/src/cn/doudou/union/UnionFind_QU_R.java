package cn.doudou.union;

/**
 * 基于树的高度进行的优化
 * Create By 王嘉浩
 * Time 2023-01-01 14:11
 */
public class UnionFind_QU_R extends UnionFind_QU {
    private int[] ranks;

    /**
     * 构造方法
     *
     * @param capacity 传入的容量
     */
    public UnionFind_QU_R(int capacity) {
        super(capacity);

        ranks = new int[capacity];
        //更新高度
        for (int i = 0; i < capacity; i++) {
            ranks[i] = 1;
        }
    }

    @Override
    public void union(int v1, int v2) {
        int p1 = find(v1);
        int p2 = find(v2);
        if (p1 == p2) return;

        //判断高度
        if (ranks[p1] < ranks[p2]) {
            parents[p1] = p2;
        } else if (ranks[p1] > ranks[p2]) {
            parents[p2] = p1;
        } else {
            parents[p1] = p2;
            ranks[p2] += 1;
        }
    }
}
