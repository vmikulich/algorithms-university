package by.bsu.graph;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EulerCycleTest {
    @Test
    void EulerCycleTest() {
        ListGraph graph = new ListGraph();
        List<Integer> expected = new ArrayList<>(Arrays.asList(1, 4, 5, 2, 4, 3, 2, 1));
        Integer[] ver = new Integer[]{1, 2, 3, 4, 5};
        graph.addVertices(ver);
        graph.addEdge(1, 2);
        graph.addEdge(1, 4);
        graph.addEdge(2, 4);
        graph.addEdge(2, 5);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        graph.addEdge(4, 5);
        EulerCycle eulercycle = new EulerCycle(graph);
        eulercycle.findEulerCycle();
        Assertions.assertTrue(expected.equals(eulercycle.getCycle()));
    }
}
