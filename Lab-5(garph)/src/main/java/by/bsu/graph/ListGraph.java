package by.bsu.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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
        return this.adjacentList.get(vertex);
    }

    public boolean isAdjacentVertices(int vertex1, int vertex2) {
        List<Integer> environmentOfVertex1 = this.getVertexEnvironment(vertex1);
        if (environmentOfVertex1.isEmpty()) {
            return false;
        }
        return environmentOfVertex1.contains(vertex2);
    }

    public static void main(String[] args) {
        ListGraph graph = new ListGraph();
        graph.addVertex(1);
        System.out.println(graph.getAdjacentList());
        graph.addEdge(1, 2);
        System.out.println(graph.getAdjacentList());
        System.out.println(graph.isAdjacentVertices(1, 2));
    }
}
