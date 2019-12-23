package by.bsu.stableMarriageProblem;

import java.util.*;

public class StableMarriageProblem {
    public static void main(String[] args) {

        int[][] priorities = {
                {1,0,2,3,4},
                {4,1,2,3,0},
                {2,3,1,0,4},
                {1,4,3,2,0},
                {2,0,4,1,3}
        };

        int[][] estimations = {
                {12,8,3,5,10},//{3,4,2,5,1}
                {11,13,7,9,10},
                {14,10,9,5,8},
                {13,14,10,8,11},
                {11,13,14,9,15}
        };


        Set<Integer> availableTasks = new HashSet <> ();
        for (int i=0; i<estimations.length; i++) {
            availableTasks.add(i);
        }
        Map<Integer, Integer> availableCoders = new HashMap <> ();
        for (int i=0; i<priorities.length; i++) {
            availableCoders.put(i, null);
        }
        while (availableTasks.size() > 0) {
            int currentTask = availableTasks.iterator().next();
            SortedMap<Integer, Integer> sortedMap = new TreeMap<>();
            for (int i = 0; i<estimations[currentTask].length; i++) {
                sortedMap.put(estimations[currentTask][i],i);
            }
            for(Map.Entry<Integer,Integer> entry : sortedMap.entrySet()) {
                Integer task = availableCoders.get(entry.getValue());
                if (task == null) {
                    availableCoders.put(entry.getValue(), currentTask);
                    availableTasks.remove(currentTask);
                    break;
                }
                else {
                    int prefForTask = -1;
                    int prefForCurrentTask = -1;
                    for (int k = 0; k < priorities[entry.getValue()].length; k++){
                        if (priorities[entry.getValue()][k] == task) {
                            prefForTask = k;
                        }
                        if (priorities[entry.getValue()][k] == currentTask) {
                            prefForCurrentTask = k;
                        }
                    }
                    if (prefForCurrentTask < prefForTask){
                        availableCoders.put(entry.getValue(), currentTask);
                        availableTasks.remove(currentTask);
                        availableTasks.add(task);
                        break;
                    }
                }
            }
        }

        int totalEfficiency = 0;
        System.out.println();
        Iterator<Map.Entry<Integer, Integer>> itr = availableCoders.entrySet().iterator();
        while (itr.hasNext()){
            Map.Entry<Integer, Integer> entry = itr.next();
            System.out.println ("T-" + entry.getValue() + " Taken by C-" + entry.getKey());
            totalEfficiency+=estimations[entry.getValue()][entry.getKey()];
        }
        System.out.println("Total efficiency: " + totalEfficiency);

    }

}
