package by.bsu.mergeSort.util;

import by.bsu.mergeSort.sort.mergeSort;

import java.util.Date;

import static by.bsu.mergeSort.sort.MixedSort.mixedSort;

public class RunSort {

    public static void runMixedSort (Integer[] arr, int k) {
        long prevTime = 99999999;
        while (true) {
            Integer[] arrCopy = arr.clone();
            Date date = new Date();
            long first = date.getTime();
            mixedSort(arrCopy, k);
            long time = new Date().getTime() - first;
            if (time > prevTime) {
                System.out.println("Time: " + prevTime);
                System.out.println("K: " + (k + 3));
                break;
            }
            prevTime = time;
            k++;
        }
    }

    public static void runMergeSort (Integer[] arr) {
        Date date = new Date();
        long first = date.getTime();
        mergeSort.mergeSort(arr);
        long time = new Date().getTime() - first;
        System.out.println("Time: " + time);
    }
}
