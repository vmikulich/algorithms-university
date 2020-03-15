package by.bsu.graph.util;

import by.bsu.graph.ListGraph;

import java.util.*;

public class Methods {
    public static boolean isGraphConnected(ListGraph graph) {
        return graph.countOfVertices() == graph.breadthFirstSearch().size();
    }

    public static boolean isBipartite(ListGraph graph) {
        List<Integer> vertices = new ArrayList<>();
        vertices.addAll(graph.getAdjacentList().keySet());
        int vertex = vertices.get(0);
        HashMap<Integer, Integer> colors = new HashMap<>();
        colors.put(vertex, 1);
        int iterationCount = graph.getVertexEnvironment(vertex).size();
        HashSet<Integer> visitedVertices = new HashSet<>(vertex);
        for (int currentVertex:graph.breadthFirstSearch()) {
            if (!visitedVertices.contains(currentVertex)) {
                visitedVertices.add(currentVertex);
                colors.put(currentVertex, colors.get(vertex) - 1);
            }
            else if (colors.get(currentVertex) == colors.get(vertex) && currentVertex != vertex) {
                return false;
            }
            if (iterationCount == 0) {
                vertex = currentVertex;
                iterationCount = graph.getVertexEnvironment(currentVertex).size();
            }
            iterationCount -= 1;
        }
        return true;
    }

    public static void main(String[] args) {
        ListGraph graph = new ListGraph();
        Integer[] ver = new Integer[]{1, 2, 3};
        graph.addVertices(ver);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        graph.addEdge(4, 5);
        graph.addEdge(5, 1);
        System.out.println(isBipartite(graph));
    }
}
