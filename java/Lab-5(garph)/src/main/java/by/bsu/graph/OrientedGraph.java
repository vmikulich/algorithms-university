package by.bsu.graph;

import java.security.PublicKey;
import java.util.*;

public class OrientedGraph {

    private HashMap<Integer, List<Integer>> adjacentList;

    public OrientedGraph() {
        this.adjacentList = new HashMap<>();
    }

    public HashMap<Integer, List<Integer>> getAdjacentList() {
        return adjacentList;
    }

    public void addVertex(int vertex) throws RuntimeException {
        if (this.adjacentList.containsKey(vertex)) {
            throw new RuntimeException("Such vertex has already exist");
        }
        this.adjacentList.put(vertex, new ArrayList<>());
    }

    public void addVertices(Integer[] vertices) {
        for (int vertex: vertices) {
            this.addVertex(vertex);
        }
    }

    public void setAdjacentList(HashMap<Integer, List<Integer>> adjacentList) {
        this.adjacentList = adjacentList;
    }

    public void addEdge(int vertex1, int vertex2) {
        if (this.adjacentList.containsKey(vertex1)) {
            this.adjacentList.get(vertex1).add(vertex2);
        } else {
            addVertex(vertex1);
            this.adjacentList.get(vertex1).add(vertex2);
        }
        if (!this.adjacentList.containsKey(vertex2)) {
            addVertex(vertex2);
        }
    }

    public void removeEdge(int vertex1, int vertex2) {
        if (!this.adjacentList.containsKey(vertex1) || !this.adjacentList.containsKey(vertex2)) {
            throw new RuntimeException("This edge isn't exist");
        }
        List<Integer> list1 = this.adjacentList.get(vertex1);
        int index1 = list1.indexOf(vertex2);
        list1.remove(index1);
    }

    public List<Integer> getVertexEnvironment(int vertex) {
        if (!adjacentList.keySet().contains(vertex)) {
            return null;
        }
        return this.adjacentList.get(vertex);
    }

    public List<Integer> getStartVertices() {
        if (this.adjacentList.size() == 0) {
            return null;
        }
        HashSet<Integer> vertices = new HashSet<>(this.adjacentList.keySet());
        HashSet<Integer> resultSet = new HashSet<>();
        for (int vertex: vertices) {
            List<Integer> environment = this.getVertexEnvironment(vertex);
            resultSet.addAll(environment);
        }
        List<Integer> difference = new ArrayList<>();
        for (int vertex: vertices) {
            if (!resultSet.contains(vertex)) {
                difference.add(vertex);
            }
        }
        if (difference.isEmpty()) {
            List<Integer> start = new ArrayList<>();
            List<Integer> temp = new ArrayList<>();
            temp.addAll(vertices);
            start.add(temp.get(0));
            return start;
        }
        return difference;
    }

    public List<Integer> depthFirstSearch() {
        if (this.adjacentList.size() == 0) {
            return new ArrayList<>();
        }
        HashSet<Integer> visitedVertices = new HashSet<>();
        List<Integer> verticesList = new ArrayList<>();
        List<Integer> startVertices = getStartVertices();
        for (int vertex:startVertices) {
            depthFirstSearchHelper(vertex, verticesList, visitedVertices);
        }
        return verticesList;
    }

    public void depthFirstSearchHelper(int currentVertex, List<Integer> verticesList, HashSet<Integer> visitedVertices) {
        visitedVertices.add(currentVertex);
        verticesList.add(currentVertex);
        for (int vertex: this.getVertexEnvironment(currentVertex)) {
            if (!visitedVertices.contains(vertex)) {
                depthFirstSearchHelper(vertex, verticesList, visitedVertices);
            }
        }
    }
}
