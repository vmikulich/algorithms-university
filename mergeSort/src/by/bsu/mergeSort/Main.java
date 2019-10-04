package by.bsu.mergeSort;

import by.bsu.mergeSort.sort.MixedSort;
import by.bsu.mergeSort.sort.mergeSort;
import by.bsu.mergeSort.util.RunSort;

import java.util.Arrays;
import java.util.Date;

import static by.bsu.mergeSort.util.Random.createRandomArray;

public class Main {
    public static void main(String[] args) {
        Integer[] arr = {8, 75, 53, 100, 29, 15, 74, 86, 85, 16, 6, 84, 38, 91, 84, 28};
//        Integer[] arr1 = arr.clone();
        int k = 4;
        Integer[] arr1 = createRandomArray(0, 50, (int) Math.pow(10, 3));
        Integer[] arrCopy1 = arr1.clone();
        Integer[] arr2 = createRandomArray(0, 50, (int) Math.pow(10, 4));
        Integer[] arrCopy2 = arr2.clone();
        Integer[] arr3 = createRandomArray(0, 100, (int) Math.pow(10, 4));
        Integer[] arrCopy3 = arr3.clone();

        System.out.println("-------------------------");
        System.out.println("Range: 50" + ", Amount: 10^3");
        System.out.println("Merge sort");
        RunSort.runMergeSort(arr1);
        System.out.println("Mixed sort");
        RunSort.runMixedSort(arrCopy1, k);
        System.out.println("-------------------------");
        System.out.println("Range: 50" + ", Amount: 10^4");
        System.out.println("Merge sort");
        RunSort.runMergeSort(arr2);
        System.out.println("Mixed sort");
        RunSort.runMixedSort(arrCopy2, k);
        System.out.println("-------------------------");
        System.out.println("Range: 100" + ", Amount: 10^4");
        System.out.println("Merge sort");
        RunSort.runMergeSort(arr3);
        System.out.println("Mixed sort");
        RunSort.runMixedSort(arrCopy3, k);
    }
}
