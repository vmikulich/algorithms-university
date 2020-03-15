package by.bsu.graph;

import by.bsu.graph.util.Methods;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ListGraphTest {
    ListGraph graph = new ListGraph();

    @BeforeEach
    public void initialization() {
        graph.addVertex(1);
        graph.addVertex(2);
        graph.addVertex(4);
        graph.addEdge(1, 2);
        graph.addEdge(1, 4);
        graph.addEdge(5, 3);
    }

    @Test
    public void testAddVertex() {
        assertTrue(graph.getAdjacentList().get(1).isEmpty());
        assertTrue(graph.getAdjacentList().get(2).isEmpty());
        assertTrue(graph.getAdjacentList().get(4).isEmpty());
    }

    @Test
    public void testAddEdge() {
        List<Integer> expected1 = new ArrayList<>();
        expected1.add(2);
        expected1.add(4);
        List<Integer> expected2 = new ArrayList<>();
        expected2.add(1);
        List<Integer> expected3 = new ArrayList<>();
        expected3.add(1);
        List<Integer> expected4 = new ArrayList<>();
        expected4.add(3);
        List<Integer> expected5 = new ArrayList<>();
        expected5.add(5);
        assertTrue(graph.getAdjacentList().get(1).equals(expected1));
        assertTrue(graph.getAdjacentList().get(2).equals(expected2));
        assertTrue(graph.getAdjacentList().get(4).equals(expected3));
        assertTrue(graph.getAdjacentList().get(5).equals(expected4));
        assertTrue(graph.getAdjacentList().get(3).equals(expected5));
    }

    @Test
    public void testRemoveEdge() {
        List<Integer> expected1 = new ArrayList<>();
        expected1.add(2);
        expected1.add(4);
        assertTrue(graph.getAdjacentList().get(1).equals(expected1));
        graph.removeEdge(1, 2);
        graph.removeEdge(1, 4);
        assertTrue(graph.getAdjacentList().get(1).isEmpty());
    }

    @Test
    public void testGetVertexEnvironment() {
        List<Integer> expected1 = new ArrayList<>();
        expected1.add(2);
        expected1.add(4);
        List<Integer> expected2 = new ArrayList<>();
        expected2.add(1);
        assertTrue(graph.getAdjacentList().get(1).equals(expected1));
        assertTrue(graph.getAdjacentList().get(2).equals(expected2));
        Assertions.assertFalse(graph.getAdjacentList().keySet().contains(200));
    }

    @Test
    public void testIsGraphConnected() {
        ListGraph graph1 = new ListGraph();
        graph1.addEdge(1, 3);
        graph1.addEdge(3, 4);
        graph1.addEdge(3, 5);
        Assertions.assertFalse(Methods.isGraphConnected(graph));
        assertTrue(Methods.isGraphConnected(graph1));
    }

    @Test
    public void testIsBipartite() {
        ListGraph graph = new ListGraph();
        Integer[] ver = new Integer[]{1, 2, 3};
        graph.addVertices(ver);
        assertTrue(Methods.isBipartite(graph));
        graph.addEdge(1, 2);
        graph.addEdge(3, 4);
        graph.addEdge(1, 2);
        graph.addEdge(1, 4);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        graph.addEdge(4, 5);
        graph.addEdge(5, 6);
        assertTrue(Methods.isBipartite(graph));
        graph.addEdge(5, 6);
        graph.addEdge(1, 5);
        assertTrue(Methods.isBipartite(graph));
    }

}
