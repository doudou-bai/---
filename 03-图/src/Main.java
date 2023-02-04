import cn.doudou.Data;
import cn.doudou.Graph;
import cn.doudou.ListGraph;

import java.io.IOException;
import java.util.List;

/**
 * Create By 王嘉浩
 * Time 2023-01-06 15:37
 */

public class Main {
    public static void main(String[] args) {

//        test();
//        testBFS_02();
//        testBFS_02();
//        testDfs();
        testTopo();
    }

    static void testTopo() {
        Graph<Object, Double> graph = directedGraph(Data.TOPO);
        List<Object> topologicalsort = graph.topologicalsort();
        System.out.println(topologicalsort);
    }

    static void testDfs() {
        Graph<Object, Double> graph = directedGraph(Data.DFS_02);
        graph.dfs("c");
    }

    static void testBFS_02() {
        Graph<Object, Double> graph = directedGraph(Data.BFS_02);
        graph.bfs(7);
    }

    static void testBFS_01() {
        Graph<Object, Double> graph = undirectedGraph(Data.BFS_01);

        graph.bfs("A");
    }

    static void test() {
        ListGraph<String, Integer> graph = new ListGraph<>();
        graph.addEdge("V1", "V0", 9);
        graph.addEdge("V1", "V2", 3);
        graph.addEdge("V2", "V0", 2);
        graph.addEdge("V2", "V3", 5);
        graph.addEdge("V3", "V4", 1);
        graph.addEdge("V0", "V4", 6);

        graph.bfs("V1");
//        graph.removeEdge("V0", "V4");
//        graph.removeEdge("V2", "V3");

        /*  graph.removeVertex("V0");
        graph.print();*/


       /* graph.addEdge("V0", "V1");
        graph.addEdge("V1", "V0");

        graph.addEdge("V0", "V2");
        graph.addEdge("V2", "V0");

        graph.addEdge("V0", "V3");
        graph.addEdge("V3", "V0");

        graph.addEdge("V2", "V1");
        graph.addEdge("V1", "V2");

        graph.addEdge("V2", "V3");
        graph.addEdge("V3", "V2");*/

    }


    /**
     * 有向图
     */
    private static Graph<Object, Double> directedGraph(Object[][] data) {
        Graph<Object, Double> graph = new ListGraph<>();
        for (Object[] edge : data) {
            if (edge.length == 1) {
                graph.addVertex(edge[0]);
            } else if (edge.length == 2) {
                graph.addEdge(edge[0], edge[1]);
            } else if (edge.length == 3) {
                double weight = Double.parseDouble(edge[2].toString());
                graph.addEdge(edge[0], edge[1], weight);
            }
        }
        return graph;
    }

    /**
     * 无向图
     *
     * @param data
     * @return
     */
    private static Graph<Object, Double> undirectedGraph(Object[][] data) {
        Graph<Object, Double> graph = new ListGraph<>();
        for (Object[] edge : data) {
            if (edge.length == 1) {
                graph.addVertex(edge[0]);
            } else if (edge.length == 2) {
                graph.addEdge(edge[0], edge[1]);
                graph.addEdge(edge[1], edge[0]);
            } else if (edge.length == 3) {
                double weight = Double.parseDouble(edge[2].toString());
                graph.addEdge(edge[0], edge[1], weight);
                graph.addEdge(edge[1], edge[0], weight);
            }
        }
        return graph;
    }
}
