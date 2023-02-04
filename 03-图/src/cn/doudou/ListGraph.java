package cn.doudou;


import java.util.*;

/**
 * Create By 王嘉浩
 * Time 2023-01-06 15:58
 */

public class ListGraph<V, E> implements Graph<V, E> {
    private Map<V, Vertex<V, E>> vertices = new HashMap<>();
    private Set<Edge<V, E>> edges = new HashSet<>();

    public void print() {
        vertices.forEach((V v, Vertex<V, E> vertex) -> {
            System.out.println(v);
            System.out.println("out-------------------out");
            System.out.println(vertex.outEdges);
            System.out.println("in-------------------in");
            System.out.println(vertex.inEdges);
            System.out.println("=================================\n");
        });

        edges.forEach((Edge<V, E> edge) -> {
            System.out.println(edge);
        });
    }


    @Override
    public int edgesSize() {
        return edges.size();
    }

    @Override
    public int verticesSize() {
        return vertices.size();
    }

    @Override
    public void addVertex(V v) {
        if (vertices.containsKey(v)) return;
        vertices.put(v, new Vertex<>(v));
    }

    @Override
    public void addEdge(V from, V to) {
        addEdge(from, to, null);
    }

    /**
     * @param from   起点
     * @param to     结束点
     * @param weight 权重值
     */
    @Override
    public void addEdge(V from, V to, E weight) {
        //查看有没有from的点
        Vertex<V, E> fromVertex = vertices.get(from);
        if (fromVertex == null) {
            fromVertex = new Vertex<>(from);
            vertices.put(from, fromVertex);
        }

        //查看有没有to的点
        Vertex<V, E> toVertex = vertices.get(to);
        if (toVertex == null) {
            toVertex = new Vertex<>(to);
            vertices.put(to, toVertex);
        }

        //创建一个from->to的点
        Edge<V, E> edge = new Edge<>(fromVertex, toVertex);
        //更新权重值
        edge.weight = weight;

        //删除原来的边 如果删除成功 就代表以前有着边
        if (fromVertex.outEdges.remove(edge)) {
            //更新边
            toVertex.inEdges.remove(edge);
            edges.remove(edge);
        }

        fromVertex.outEdges.add(edge);
        toVertex.inEdges.add(edge);
        edges.add(edge);
    }

    @Override
    public void removeVertex(V v) {
        Vertex<V, E> vertex = vertices.remove(v);
        if (vertex == null) return;

        for (Iterator<Edge<V, E>> iterator = vertex.outEdges.iterator(); iterator.hasNext(); ) {
            Edge<V, E> edge = iterator.next();
            edge.to.inEdges.remove(edge);
            iterator.remove();
            edges.remove(edge);
        }

        for (Iterator<Edge<V, E>> iterator = vertex.inEdges.iterator(); iterator.hasNext(); ) {
            Edge<V, E> edge = iterator.next();
            edge.from.outEdges.remove(edge);
            iterator.remove();
            edges.remove(edge);
        }

    }


    @Override
    public void removeEdge(V from, V to) {
        Vertex<V, E> fromVertex = vertices.get(from);
        if (fromVertex == null) return;

        Vertex<V, E> toVertex = vertices.get(to);
        if (toVertex == null) return;

        /**
         * 拿到fromVertex和toVertex进行new一个对象
         *自己重新写了hashCode方法所以我们只需要比较是不是一样就可以了
         */
        Edge<V, E> edge = new Edge<>(fromVertex, toVertex);
        if (fromVertex.outEdges.remove(edge)) {
            toVertex.inEdges.remove(edge);
            edges.remove(edge);
        }

    }

    @Override
    public void bfs(V begin) {
        //取出Vertex 判断是否为空
        Vertex<V, E> beginvertex = vertices.get(begin);
        if (beginvertex == null) return;

        //创建一个set进行存储已经遍历过的节点
        Set<Vertex<V, E>> vesitedVertices = new HashSet<>();
        //创建队列
        Queue<Vertex<V, E>> queue = new LinkedList<>();
        //向对列添加元素
        queue.offer(beginvertex);
        //向set添加节点
        vesitedVertices.add(beginvertex);

        //判断队列不为空就弹出第一个元素
        while (!queue.isEmpty()) {
            Vertex<V, E> vertex = queue.poll();
            System.out.println(vertex.value);

            //遍历获得节点的出的边的集合
            for (Edge<V, E> outEdge : vertex.outEdges) {
                //判断这个边是不是以前遍历过 没有的话就添加进去
                if (!vesitedVertices.contains(outEdge.to)) {
                    queue.offer(outEdge.to);
                    //再次向set集合进行添加
                    vesitedVertices.add(outEdge.to);
                }
            }
        }
    }

    @Override
    public void dfs(V begin) {
        //取出Vertex 判断是否为空
        Vertex<V, E> beginvertex = vertices.get(begin);
        if (beginvertex == null) return;

        //创建一个set集合进行存储访问过的数据
        Set<Vertex<V, E>> visitedVertices = new HashSet<>();
        Stack<Vertex<V, E>> stack = new Stack();

        //打印元素
        System.out.println(beginvertex.value);
        stack.push(beginvertex);
        visitedVertices.add(beginvertex);

        while (!stack.isEmpty()) {
            Vertex<V, E> vertex = stack.pop();

            for (Edge<V, E> edge : vertex.outEdges) {
                if (visitedVertices.contains(edge.to)) continue;

                stack.push(edge.from);
                stack.push(edge.to);
                visitedVertices.add(edge.to);
                System.out.println(edge.to.value);

                break;
            }
        }


    }

    @Override
    public List<V> topologicalsort() {
        //返回结果
        List<V> list = new ArrayList<>();
        Queue<Vertex<V, E>> queue = new LinkedList();
        Map<Vertex<V, E>, Integer> ins = new HashMap<>();

        //遍历查看入度为0的顶点 加进queue
        vertices.forEach((V v, Vertex<V, E> vertex) -> {
            int in = vertex.inEdges.size();
            if (in == 0) {//如果等于0 就代表自身就是一个顶点  没有从别的顶点向自身指向
                queue.offer(vertex);
            } else {//维护入度表
                ins.put(vertex, vertex.inEdges.size());
            }
        });

        while (!queue.isEmpty()) {
            Vertex<V, E> vertex = queue.poll();
            //加入结果集
            list.add(vertex.value);
            //遍历outEdges
            for (Edge<V, E> edge : vertex.outEdges) {
                //先从map里面进行获取然后-1 判断是不是为0 是的话就加入到队列
                int toIn = ins.get(edge.to) - 1;
                if (toIn == 0) {
                    queue.offer(edge.to);
                } else {//更新入度表
                    ins.put(edge.to, toIn);
                }
            }
        }
        return list;
    }


    /**
     * 递归版的实现方式
     */
   /* public void dfs(V begin) {
        //取出Vertex 判断是否为空
        Vertex<V, E> beginvertex = vertices.get(begin);
        if (beginvertex == null) return;

        //创建一个set集合进行存储访问过的数据
        Set<Vertex<V, E>> visitedVertices = new HashSet<>();

        dfs(beginvertex, visitedVertices);
    }

    private void dfs(Vertex<V, E> vertex, Set<Vertex<V, E>> visitedVertices) {
        //打印值
        System.out.println(vertex.value);
        //打印后就代表数据已经使用过了 直接向set进行添加
        visitedVertices.add(vertex);

        //循环遍历从这个顶点出去的边
        for (Edge<V, E> outEdge : vertex.outEdges) {
            //去set进行里面进行查找是不是已经访问过的数据 如果是话就跳出这次循环
            if (visitedVertices.contains(outEdge.to)) continue;
            dfs(outEdge.to, visitedVertices);
        }
    }
*/

    /**
     * 顶点内部类
     *
     * @param <V>
     * @param <E>
     */
    private static class Vertex<V, E> {
        //存储的元素
        V value;
        //开始的边
        Set<Edge<V, E>> inEdges = new HashSet<>();
        //结束的边
        Set<Edge<V, E>> outEdges = new HashSet<>();

        public Vertex(V value) {
            this.value = value;
        }

        @Override
        public boolean equals(Object o) {
            return Objects.equals(value, ((Vertex<V, E>) o).value);
        }

        @Override
        public int hashCode() {
            return value == null ? 0 : value.hashCode();
        }

        @Override
        public String toString() {
            return value == null ? "" : value.toString();
        }
    }

    /**
     * 边内部类
     *
     * @param <V>
     * @param <E>
     */
    private static class Edge<V, E> {
        //开始的顶点
        Vertex<V, E> from;
        //结束的顶点
        Vertex<V, E> to;
        //权重值
        E weight;

        public Edge(Vertex<V, E> from, Vertex<V, E> to) {
            this.from = from;
            this.to = to;
        }

        @Override
        public boolean equals(Object o) {
            Edge<V, E> edge = (Edge<V, E>) o;

            //判断from和to 相等就代表他们之间存在一条边
            return Objects.equals(edge.from, from) && Objects.equals(edge.to, to);
        }

        @Override
        public int hashCode() {
            return from.hashCode() * 31 + to.hashCode();
        }

        @Override
        public String toString() {
            return "Edge{" +
                    "from=" + from +
                    ", to=" + to +
                    ", weight=" + weight +
                    '}';
        }
    }
}
