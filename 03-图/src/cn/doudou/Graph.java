package cn.doudou;

import java.util.List;

/**
 * Create By 王嘉浩
 * Time 2023-01-06 15:37
 */
public interface Graph<V, E> {
    /**
     * 边的数量
     *
     * @return
     */
    int edgesSize();

    /**
     * 顶点的数量
     *
     * @return
     */
    int verticesSize();

    /**
     * 新增一个顶点
     *
     * @param v
     */
    void addVertex(V v);

    /**
     * 新增一条边
     *
     * @param from
     * @param to
     */
    void addEdge(V from, V to);

    /**
     * 新增一条有权重值的边
     *
     * @param from
     * @param to
     * @param weight
     */
    void addEdge(V from, V to, E weight);

    /**
     * 删除一个顶点
     *
     * @param v
     */
    void removeVertex(V v);

    /**
     * 删除一条边
     *
     * @param from
     * @param to
     */
    void removeEdge(V from, V to);

    /**
     * 广度优先搜索
     * 给指定的节点 遍历打印节点
     *
     * @param begin
     */
    void bfs(V begin);

    /**
     * 深度优先搜索
     * 给指定的节点 遍历打印节点
     *
     * @param begin
     */
    void dfs(V begin);

    /**
     * 拓扑排序的实现过程
     *
     * @return
     */
    List<V> topologicalsort();
}
