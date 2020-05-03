package by.bsu.graph.util;

import by.bsu.graph.ListGraph;

import java.util.*;
import java.util.stream.Collectors;

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

    private static Integer chooseVertexToColorDsatur(ListGraph graph, List<Integer> notColoredVertices, HashMap<Integer,HashSet<Integer>> adjacentVerticesColors) {
        Integer vertexToColor = notColoredVertices.get(0);
        for (int vertex: notColoredVertices) {
            boolean saturation_greater = adjacentVerticesColors.get(vertex).size() > adjacentVerticesColors.get(vertexToColor).size();
            boolean saturation_equal = adjacentVerticesColors.get(vertex).size() == adjacentVerticesColors.get(vertexToColor).size();
            boolean degree = graph.getVertexDegree(vertex) > graph.getVertexDegree(vertexToColor);
            if (saturation_greater || saturation_equal && degree) {
                vertexToColor = vertex;
            }
        }
        return vertexToColor;
    }

    private static Integer chooseColor(Integer colorsNumber, HashSet<Integer> adjacentVertexColors) {
        List<Integer> adjacentVertexColorsList = new ArrayList<>(adjacentVertexColors);
        List<Integer> colors = new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < colorsNumber + 1; i++) {
            colors.add(i);
        }
        for (int i = 0; i < colors.size(); i++) {
            if (!adjacentVertexColorsList.contains(colors.get(i))) {
                res.add(colors.get(i));
            }
        }
        Collections.sort(res);
        return res.get(0);
    }

    public static HashMap<Integer, Integer> dsatur(ListGraph graph) {
        HashMap<Integer, Integer> verticesColors = new HashMap<>();
        List<Integer> notColoredVertices = new ArrayList<>(graph.getAllVertices());
        Integer numberOfUsedColors = 0;
        HashMap<Integer,HashSet<Integer>> adjacentVerticesColors = new HashMap<>();
        for (int vertex: notColoredVertices) {
            adjacentVerticesColors.put(vertex, new HashSet<>());
        }
        while(notColoredVertices.size() != 0) {
            Integer vertexToColor = chooseVertexToColorDsatur(graph, notColoredVertices, adjacentVerticesColors);
            Integer color = chooseColor(numberOfUsedColors, adjacentVerticesColors.get(vertexToColor));
            verticesColors.put(vertexToColor, color);
            numberOfUsedColors = Math.max(numberOfUsedColors, color + 1);
            notColoredVertices.remove(vertexToColor);
            for (int adjacentVertex: graph.getVertexEnvironment(vertexToColor)) {
                adjacentVerticesColors.get(adjacentVertex).add(color);
            }
        }
        return verticesColors;
    }

    private static List<Integer> chooseVerticesGis(List<Integer> notColoredVertices, HashMap<Integer,HashSet<Integer>> adjacentVerticesColors, Integer color) {
        List<Integer> vertices = new ArrayList<>();
        for (int vertex: notColoredVertices) {
            if (!adjacentVerticesColors.get(vertex).contains(color)) {
                vertices.add(vertex);
            }
        }
        return vertices;
    }

    public static HashMap<Integer, Integer> gis(ListGraph graph) {
        HashMap<Integer, Integer> verticesColors = new HashMap<>();
        List<Integer> notColoredVertices = new ArrayList<>(graph.getAllVertices());
        Integer currentColor = 0;
        HashMap<Integer,HashSet<Integer>> adjacentVerticesColors = new HashMap<>();
        for (int vertex: notColoredVertices) {
            adjacentVerticesColors.put(vertex, new HashSet<>());
        }
        while(notColoredVertices.size() != 0) {
            List<Integer> verticesToColor = chooseVerticesGis(notColoredVertices, adjacentVerticesColors, currentColor);
            List<Integer> sortedVerticesToColor = verticesToColor.stream().sorted((v1, v2) -> {
                Integer size1 = graph.getVertexEnvironment(v1).size();
                Integer size2 = graph.getVertexEnvironment(v2).size();
                return size1.compareTo(size2);
            }).collect(Collectors.toList());
            for (int vertex: sortedVerticesToColor) {
                if (!adjacentVerticesColors.get(vertex).contains(currentColor)) {
                    verticesColors.put(vertex, currentColor);
                    notColoredVertices.remove(Integer.valueOf(vertex));
                    for (int adjacentVertex: graph.getVertexEnvironment(vertex)) {
                        adjacentVerticesColors.get(adjacentVertex).add(currentColor);
                    }
                }
            }
            currentColor += 1;
        }
        return  verticesColors;
    }

//    public static void main(String[] args) throws CloneNotSupportedException {
//        ListGraph graph = new ListGraph();
//        graph.addEdge(1, 2);
//        graph.addEdge(1, 7);
//        graph.addEdge(2, 3);
//        graph.addEdge(7, 6);
//        graph.addEdge(6, 3);
//        graph.addEdge(3, 4);
//        graph.addEdge(6, 4);
//        graph.addEdge(6, 5);
//        graph.addEdge(5, 4);
//        System.out.println(gis(graph));
//    }
}
