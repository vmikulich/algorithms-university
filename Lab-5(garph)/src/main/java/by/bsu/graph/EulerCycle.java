package by.bsu.graph;


import by.bsu.graph.util.Methods;

import javax.print.DocFlavor;
import java.util.*;

public class EulerCycle {
    private ListGraph graph;
    private List<Integer> cycle;

    public EulerCycle(ListGraph graph){
        this.graph = graph;
        cycle = new LinkedList<>();
    }

    public List<Integer> getCycle(){
        return cycle;
    }

    public boolean isEulerGraph(){
        if (Methods.isGraphConnected(graph)){
            for (int vertex: graph.getAdjacentList().keySet()) {
                if (graph.getAdjacentList().get(vertex).size() % 2 != 0){
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public void findEulerCycle(){
        if (!isEulerGraph()){
            return;
        }
        ListGraph newGraph = new ListGraph();
        HashMap<Integer, List<Integer>> copyOfGraph = new HashMap<>(graph.getAdjacentList());
        newGraph.setAdjacentList(copyOfGraph);
        Stack<Integer> stack = new Stack<>();
        int vertex = 1;
        stack.push(vertex);
        makeCycle(newGraph,stack);
    }

    private void makeCycle(ListGraph graph, Stack<Integer> stack){
        int vertex;
        while (!stack.isEmpty()){
            vertex = stack.peek();
            for (int i: graph.getAdjacentList().keySet()) {
                if (graph.getAdjacentList().get(vertex).contains(i)) {
                    stack.push(i);
                    graph.removeEdge(vertex ,i);
                    makeCycle(graph, stack);
                }
            }
            if (!stack.isEmpty()){
                cycle.add(stack.pop());
            } else {
                break;
            }
        }
    }
}
