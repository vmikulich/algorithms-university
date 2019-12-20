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
//            for (int i = 0; i<graph.length;i++){
//                if (graph[vertex][i]==1){
//                    stack.push(i);
//                    graph[vertex][i]=0;
//                    graph[i][vertex]=0;
//                    makeCycle(graph,stack);
//                    break;
//                }
//            }
            for (int i: graph.getAdjacentList().keySet()) {
                if (graph.getAdjacentList().get(vertex).contains(i)) {
                    stack.push(i);
//                    int index1 = graph.get(vertex).indexOf(i);
//                    int index2 = graph.get(i).indexOf(vertex);
//                    graph.get(vertex).remove(index1);
//                    graph.get(index2).remove(vertex);
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

    public static void main(String[] args) {
//        int g[][] = {
//                {0, 1, 1, 0, 1, 0, 0, 0, 1, 0, 0, 0},
//                {1, 0, 1, 0, 1, 0, 0, 0, 0, 1, 0, 0},
//                {1, 1, 0, 1, 0, 1, 1, 0, 0, 0, 0, 1},
//                {0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 1, 1},
//                {1, 1, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0},
//                {0, 0, 1, 1, 1, 0, 0, 1, 0, 1, 1, 0},
//                {0, 0, 1, 0, 1, 0, 0, 1, 1, 1, 1, 0},
//                {0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 1, 1},
//                {1, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 1},
//                {0, 1, 0, 0, 0, 1, 1, 0, 1, 0, 1, 1},
//                {0, 0, 0, 1, 0, 1, 1, 1, 0, 1, 0, 1},
//                {0, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0},
//        };
        ListGraph graph = new ListGraph();
        Integer[] ver = new Integer[]{1, 2, 3, 4, 5};
        graph.addVertices(ver);
//        graph.addEdge(1, 2);
//        graph.addEdge(1, 3);
//        graph.addEdge(1, 5);
//        graph.addEdge(1, 9);
//
//        graph.addEdge(2, 1);
//        graph.addEdge(2, 3);
//        graph.addEdge(2, 5);
//        graph.addEdge(2, 10);
//
//        graph.addEdge(3, 1);
//        graph.addEdge(3, 2);
//        graph.addEdge(3, 4);
//        graph.addEdge(3, 6);
//        graph.addEdge(3, 7);
//        graph.addEdge(3, 12);
//
//        graph.addEdge(4, 12);
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
