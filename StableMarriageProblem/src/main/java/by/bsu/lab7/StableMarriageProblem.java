package by.bsu.lab7;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class StableMarriageProblem {
    public static Map<Integer, Integer> stableMarriageProblem(Integer[][] men, Integer[][] women) {
        Set<Integer> availableMen = new HashSet<>();
        for (int i = 0; i < men.length; i++) {
            availableMen.add(i);
        }

        Map<Integer, Integer> availableWomen = new HashMap <> ();
        for (int i = 0; i < women.length; i++) {
            availableWomen.put(i, null);
        }

        int size = availableMen.size();

        while (size > 0) {
            int currentBachelor = availableMen.iterator().next();
            for (int w : men[currentBachelor]) {
                Integer fiance = availableWomen.get(w);

                if (fiance == null) {
                    availableWomen.put(w, currentBachelor);
                    availableMen.remove(currentBachelor);
                    break;
                } else {
                    int prefForFiance = -1;
                    int prefForCurrentBachelor = -1;
                    for (int k = 0; k < women[w].length; k++) {
                        if (women[w][k] == fiance) {
                            prefForFiance = k;
                        }
                        if (women[w][k] == currentBachelor) {
                            prefForCurrentBachelor = k;
                        }
                    }

                    if (prefForCurrentBachelor < prefForFiance) {
                        availableWomen.put (w, currentBachelor);
                        availableMen.remove(currentBachelor);
                        availableMen.add(fiance);
                        break;
                    }
                }
            }
            size = availableMen.size();
        }
        return availableWomen;
    }

//    public static void main(String[] args) {
//        Integer men[][] = {
//                {3,1,2,1,4},
//                {3,4,2,1,0},
//                {3,2,1,0,4},
//                {1,4,3,2,0},
//                {2,0,4,1,3}
//        };
//        Integer women[][] = {
//                {4,0,1,2,3},
//                {3,4,0,1,2},
//                {2,3,4,0,1},
//                {1,2,3,4,0},
//                {3,1,2,0,4}
//        };
//        System.out.println(stableMarriageProblem(men, women));
//    }
}
