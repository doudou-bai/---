package cn.doudou.union;

import javafx.scene.layout.VBox;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Create By 王嘉浩
 * Time 2023-01-02 15:40
 */
public class GenericUnionFind<V> {
    private Map<V, Node<V>> nodes = new HashMap<>();

    /**
     * 构建Node对象
     *
     * @param v
     */
    public void makeSet(V v) {
        if (nodes.containsKey(v)) return;
        nodes.put(v, new Node<>(v));
    }

    /**
     * 找到v的 根节点
     *
     * @param v
     * @return
     */
    private Node<V> findNode(V v) {
        //根据v去HashMap里面进行查找
        Node<V> node = nodes.get(v);
        //如果用户是随便进行传入的 我们需要进行判断
        if (node == null) return null;
        //找到的node的v和他父亲的v不可以相等  如果相等 就代表他自己就是自己的父亲
        while (!Objects.equals(node.value, node.parent.value)) {
            //把自己父亲给换成自己的祖父节点
            node.parent = node.parent.parent;
            //在修改下node的赋值
            node = node.parent;
        }
        //返回ndoe
        return node;
    }

    public V find(V v1) {
        Node<V> node = findNode(v1);
        return node.value == null ? null : node.value;
    }

    public void union(V v1, V v2) {
        Node<V> p1 = findNode(v1);
        Node<V> p2 = findNode(v2);
        if (p1 == null || p2 == null) return;
        if (Objects.equals(p1.value, p2.value)) return;

        //判断高度
        if (p1.rank < p2.rank) {
            p1.parent = p2;
        } else if (p1.rank > p2.rank) {
            p2.parent = p1;
        } else {
            p1.parent = p2;
            p2.rank += 1;
        }
    }

    public boolean isSame(V v1, V v2) {
        return Objects.equals(find(v1), find(v2));
    }


    private static class Node<V> {
        //构建的对象
        V value;
        //父元素
        Node<V> parent = this;
        //高度
        int rank = 1;

        public Node(V value) {
            this.value = value;
        }
    }

}
