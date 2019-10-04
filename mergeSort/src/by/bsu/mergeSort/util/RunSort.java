package by.bsu.mergeSort.util;

import by.bsu.mergeSort.sort.mergeSort;

import java.util.Date;

import static by.bsu.mergeSort.sort.MixedSort.mixedSort;

public class RunSort {

    public static void runMixedSort (Integer[] arr, int k) {
        Date date = new Date();
        long first = date.getTime();
        mergeSort.mergeSort(arr);
        long time = new Date().getTime() - first;
        k = (int) Math.ceil(Math.random()*(6 - 4) + 4);
        System.out.println("Time: " + time);
        System.out.println("K: " + k);
    }

    public static void runMergeSort (Integer[] arr) {
        long prevTime = 99999999;
        int k = 2;
        while (true) {
            Integer[] arrCopy = arr.clone();
            Date date = new Date();
            long first = date.getTime();
            mixedSort(arrCopy, k);
            long time = new Date().getTime() - first;
            if (time > prevTime) {
                System.out.println("Time: " + prevTime);
                break;
            }
            prevTime = time;
            k++;
        }
    }
}
