package by.bsu.graph;

import by.bsu.graph.util.Methods;

import java.util.*;

public class ListGraph {
    private HashMap<Integer, List<Integer>> adjacentList;

    public ListGraph() {
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
        if (this.adjacentList.containsKey(vertex2)) {
            this.adjacentList.get(vertex2).add(vertex1);
        } else {
            addVertex(vertex2);
            this.adjacentList.get(vertex2).add(vertex1);
        }
    }

    public void removeEdge(int vertex1, int vertex2) {
        if (!this.adjacentList.containsKey(vertex1) || !this.adjacentList.containsKey(vertex2)) {
            throw new RuntimeException("This edge isn't exist");
        }
        List<Integer> list1 = this.adjacentList.get(vertex1);
        List<Integer> list2 = this.adjacentList.get(vertex2);
        int index1 = list1.indexOf(vertex2);
        int index2 = list2.indexOf(vertex1);
        list1.remove(index1);
        list2.remove(index2);
    }

    public List<Integer> getVertexEnvironment(int vertex) {
        if (!adjacentList.keySet().contains(vertex)) {
            return null;
        }
        return this.adjacentList.get(vertex);
    }

    public boolean isAdjacentVertices(int vertex1, int vertex2) {
        List<Integer> environmentOfVertex1 = this.getVertexEnvironment(vertex1);
        if (environmentOfVertex1.isEmpty()) {
            return false;
        }
        return environmentOfVertex1.contains(vertex2);
    }

    public HashSet<Integer> breadthFirstSearch() {
        if (this.adjacentList.size() == 0) {
            return null;
        }
        List<Integer> vertices = new ArrayList<>();
        vertices.addAll(this.adjacentList.keySet());
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.add(vertices.get(0));
        HashSet<Integer> usedVertices = new HashSet<>();
        while (!queue.isEmpty()) {
            int vertex = queue.pop();
            List<Integer> adjacentVertices = this.adjacentList.get(vertex);
            for (int child: adjacentVertices) {
                if (!usedVertices.contains(child) && !queue.contains(child)) {
                    queue.add(child);
                }
            }
            usedVertices.add(vertex);
        }
        return usedVertices;
    }

    public Integer countOfVertices() {
        return this.adjacentList.size();
    }
}
