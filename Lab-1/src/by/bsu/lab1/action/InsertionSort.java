package by.bsu.lab1.action;

import by.bsu.lab1.utils.Swap;

public class InsertionSort {
    public static void insertionSort(Integer[] arr, int begin, int end) {
        //    1    1       1       1       2
        for(int i = begin + 1; i <= end; i++) { //
        //   1    1
            int j = i;
        //            1    1    1   1     2
            while ( j > 0 && arr[j] < arr[j - 1]) {
        //      8
                Swap.swap(arr, j, j - 1);
        //      2
                j--;
            }
        }
    }
    // 6n + 2n + 16n = 24n
}
