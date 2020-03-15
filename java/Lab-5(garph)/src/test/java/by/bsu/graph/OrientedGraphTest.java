package by.bsu.graph;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.Arrays;


public class OrientedGraphTest {
    @Test
    void dfsTest() {
        OrientedGraph graph = new OrientedGraph();
        Assertions.assertTrue(graph.depthFirstSearch().equals(new ArrayList<>()));
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(4, 2);
        graph.addEdge(1, 3);
        graph.addEdge(3, 2);
        Assertions.assertTrue(graph.depthFirstSearch().equals(new ArrayList<>(Arrays.asList(1, 2, 3, 4))));
        OrientedGraph newGraph = new OrientedGraph();
        newGraph.addEdge(1, 2);
        newGraph.addEdge(2, 3);
        newGraph.addEdge(1, 5);
        newGraph.addEdge(5, 6);
        Assertions.assertTrue(newGraph.depthFirstSearch().equals(new ArrayList<>(Arrays.asList(1, 2, 3, 5, 6))));
    }
}
