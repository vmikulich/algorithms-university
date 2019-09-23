package by.bsu.lab1;

import by.bsu.lab1.utils.Swap;

public class InsertionSort {
    public static void insertionSort(Integer[] arr, int begin, int end) {
        for(int i = begin + 1; i <= end; i++) {
            int j = i;
            while ( j > 0 && arr[j] < arr[j - 1]) {
                Swap.swap(arr, j, j - 1);
                j--;
            }
        }
    }
}
