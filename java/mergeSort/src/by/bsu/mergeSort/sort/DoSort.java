package by.bsu.mergeSort.sort;

import by.bsu.mergeSort.util.Swap;

import java.util.ArrayList;
import java.util.List;

public class DoSort {
    public static void doSort(Integer[] arr, int start, int end) {
        if (end - start < 2) {
            return;
        }
        if (end - start == 2) {
            if (arr[start] > arr[start + 1]) {
                Swap.swap(arr, start, start + 1);
            }
            return;
        }
        doSort(arr, start, start + (end - start) / 2);
        doSort(arr, start + (end - start) / 2, end);
        List<Integer> temp = new ArrayList<>();
        int st1 = start;
        int end1 = start + (end - start) / 2;
        int st2 = end1;
        while (temp.size() < end - start) {
            if (st1 >= end1 || (st2 < end && arr[st2] <= arr[st1])) {
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
