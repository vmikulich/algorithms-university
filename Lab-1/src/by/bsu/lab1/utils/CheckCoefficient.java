package by.bsu.lab1.utils;

import java.util.Date;

import static by.bsu.lab1.action.Sort.quickSort;

public class CheckCoefficient {
    public static void checkCoefficient (Integer[] arr, int k, boolean flag) {
        long prevTime = 99999999;
        while (true) {
            Integer[] arrCopy = arr.clone();
            Date date = new Date();
            long first = date.getTime();
            quickSort(arrCopy, flag, k);
            long time = new Date().getTime() - first;
            if (time > prevTime) {
                System.out.println("Time: " + prevTime);
                System.out.println("K: " + (k - 1));
                break;
            }
            prevTime = time;
            k++;
        }
    }
}
