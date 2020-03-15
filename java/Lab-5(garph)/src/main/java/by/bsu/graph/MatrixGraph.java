package by.bsu.graph;

import java.util.Arrays;

public class MatrixGraph {
    private int size = 50;
    private Integer[][] adjacentMatrix;

    public MatrixGraph(int size) {
        this.size = size;
        this.adjacentMatrix = new Integer[size][size];
    }

    public MatrixGraph() {
        this.adjacentMatrix = new Integer[size][size];
    }

    public int getSize() {
        return size;
    }

    public Integer[][] getAdjacentMatrix() {
        return adjacentMatrix;
    }

    public void printMatrix() {
        for (int i = 0; i < size; i++) {
            System.out.println(Arrays.asList(this.adjacentMatrix[i]));
        }
    }

    public void addEdge(int vertex1, int vertex2) {
        adjacentMatrix[vertex1][vertex2] = 1;
        adjacentMatrix[vertex2][vertex1] = 1;
    }

    public void removeEdge(int vertex1, int vertex2) {
        adjacentMatrix[vertex1][vertex2] = 0;
        adjacentMatrix[vertex2][vertex1] = 0;
    }

    public boolean isAdjacentVertices(int vertex1, int vertex2) {
        return adjacentMatrix[vertex1][vertex2] == 1;
    }
}
