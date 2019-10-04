package by.bsu.mergeSort.sort;

import static by.bsu.mergeSort.sort.DoMixedSort.doMixedSort;

public class MixedSort {
    public static void mixedSort(Integer[] arr, int k) {
        doMixedSort(arr, 0, arr.length - 1, k);
    }
}
