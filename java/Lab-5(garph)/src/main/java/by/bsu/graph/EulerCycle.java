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
            System.out.println("vertex - " + vertex);
            for (int i: graph.getAdjacentList().keySet()) {
                if (graph.getAdjacentList().get(vertex).contains(i)) {
                    stack.push(i);
                    System.out.println("stack - " + stack);
                    graph.removeEdge(vertex ,i);
                    makeCycle(graph, stack);
                }
            }
            if (!stack.isEmpty()){
                cycle.add(stack.pop());
                System.out.println(cycle);
                System.out.println("res" + stack);
            } else {
                break;
            }
        }
    }

    public static void main(String[] args) {
        ListGraph graph = new ListGraph();
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
        System.out.println(eulercycle.getCycle());
    }
}
