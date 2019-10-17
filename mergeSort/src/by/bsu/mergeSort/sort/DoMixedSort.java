package by.bsu.mergeSort.sort;

import by.bsu.mergeSort.util.Swap;

import java.util.ArrayList;
import java.util.List;

import static by.bsu.mergeSort.sort.InsertionSort.insertionSort;

public class DoMixedSort {
    public static void doMixedSort(Integer[] arr, int start, int end, int k) {
        if (end + 1 - start < 2) {
            return;
        }
//        if (end - start < k) {
//            insertionSort(arr, start, end);
//            return;
//        }
        if (end - start == 2) {
            if (arr[start] > arr[start + 1]) {
                Swap.swap(arr, start, start + 1);
            }
            return;
        }
        doMixedSort(arr, start, start + (end + 1 - start) / 2, k);
        doMixedSort(arr, start + (end - start) / 2, end, k);
        List<Integer> temp = new ArrayList<>();
        int st1 = start;
        int end1 = start + (end + 1 - start) / 2;
        int st2 = end1;
        while (temp.size() < end + 1 - start) {
            if (st1 >= end1 || (st2 < end + 1 && arr[st2] <= arr[st1])) {
                temp.add(arr[st2]);
                st2++;
            } else {
                temp.add(arr[st1]);
                st1++;
            }
        }
        for (int i = start; i < end; i++) {
            arr[i] = temp.get(i - start);
        }
    }
}
