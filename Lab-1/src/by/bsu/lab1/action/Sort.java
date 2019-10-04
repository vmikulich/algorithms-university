package by.bsu.lab1.action;

import static by.bsu.lab1.utils.Separartor.getSeparatorByFlag;
import static by.bsu.lab1.utils.Swap.swap;

public class Sort {
    public static void quickSort(Integer[] arr, boolean flag, int k) {
        doSort(arr, 0, arr.length - 1, flag, k);
    }

    public static void doSort(Integer[] arr, int begin0, int end0, boolean flag, int k) {
        if (end0 - begin0 <= k) {
            InsertionSort.insertionSort(arr, begin0, end0);
            return;
        }
        int separator = getSeparatorByFlag(flag, arr, end0, begin0);
        int begin = begin0;
        int end = end0;
        while (begin < end) {
            while (arr[begin] < separator) {
                begin++;
            }
            while (arr[end] > separator) {
                end--;
            }
            if (begin <= end) {
                swap(arr, begin, end);
                begin++;
                end--;
            }
        }
        doSort(arr, begin0, end, flag, k);
        doSort(arr, begin, end0, flag, k);
    }
}
