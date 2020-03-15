package by.bsu.mergeSort.sort;

import static by.bsu.mergeSort.sort.DoSort.doSort;

public class mergeSort {
    public static void mergeSort(Integer[] arr) {
        doSort(arr, 0, arr.length);
    }
}


