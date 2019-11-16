package by.bsu.graph.util;

import by.bsu.graph.ListGraph;

public class Methods {
    public static boolean isGraphConnected(ListGraph graph) {
        return graph.countOfVertices() == graph.breadthFirstSearch().size();
    }
}
