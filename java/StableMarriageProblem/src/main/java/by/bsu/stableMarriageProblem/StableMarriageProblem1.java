package by.bsu.stableMarriageProblem;

import java.util.*;

public class StableMarriageProblem1 {
    public static void stableMarriageProblem(Integer[][] estimations, Integer[][] priorities) {

        List<List<Integer>> estimationsCopy = new ArrayList<>();

        for (int i = 0; i < estimations.length; i++) {
            List<Integer> elem = new ArrayList<>();
            elem.addAll(Arrays.asList(estimations[i]));
            estimationsCopy.add(elem);
            Arrays.sort(estimations[i]);
            for (int j = 0; j < estimations[i].length; j++) {
                Integer temp = estimations[i][j];
                int index = estimationsCopy.get(i).indexOf(temp);
                estimations[i][j] = index;
            }
            System.out.println(Arrays.asList(estimations[i]));
        }

        Set<Integer> availableTasks = new HashSet<>();
        for (int i = 0; i < estimations.length; i++) {
            availableTasks.add(i);
        }

        Map<Integer, Integer> availableCoders = new HashMap <> ();
        for (int i = 0; i < priorities.length; i++) {
            availableCoders.put(i, null);
        }

        while (availableTasks.size() > 0) {
            int currentTask = availableTasks.iterator().next();

            for(int entry : estimations[currentTask]) {
                Integer task = availableCoders.get(entry);
                if (task == null) {
                    availableCoders.put(entry, currentTask);
                    availableTasks.remove(currentTask);
                    break;
                }
                else {
                    int prefForTask = -1;
                    int prefForCurrentTask = -1;
                    for (int k = 0; k < priorities[entry].length; k++){
                        if (priorities[entry][k] == task) {
                            prefForTask = k;
                        }
                        if (priorities[entry][k] == currentTask) {
                            prefForCurrentTask = k;
                        }
                    }
                    if (prefForCurrentTask < prefForTask){
                        availableCoders.put(entry, currentTask);
                        availableTasks.remove(currentTask);
                        availableTasks.add(task);
                        break;
                    }
                }
            }
        }
//
        int totalEfficiency = 0;
        System.out.println();
        Iterator<Map.Entry<Integer, Integer>> itr = availableCoders.entrySet().iterator();
        while (itr.hasNext()){
            Map.Entry<Integer, Integer> entry = itr.next();
            System.out.println ("T-" + entry.getValue() + " Taken by C-" + entry.getKey());
            totalEfficiency+=estimationsCopy.get(entry.getValue()).get(entry.getKey());
        }
        System.out.println("Total efficiency: " + totalEfficiency);
    }
}
