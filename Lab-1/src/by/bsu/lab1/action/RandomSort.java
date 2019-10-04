package by.bsu.lab1.action;

import static by.bsu.lab1.utils.Separartor.getSeparatorByFlag;
import static by.bsu.lab1.utils.Swap.swap;

public class RandomSort {
    public static void randomSort(Integer[] arr, int begin0, int end0) {
        if (begin0 >= end0) {
            return;
        }
        int separator = arr[(int) Math.ceil(Math.random()*(end0 - begin0) + begin0)];
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
        randomSort(arr, begin0, end);
        randomSort(arr, begin, end0);
    }
}
