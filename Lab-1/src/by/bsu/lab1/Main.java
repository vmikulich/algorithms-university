package by.bsu.lab1;

import by.bsu.lab1.utils.Random;
import by.bsu.lab1.utils.RunSort;

import static by.bsu.lab1.utils.CheckCoefficient.checkCoefficient;

public class Main {
    public static void main(String[] args) {
        Integer[] arr1 = Random.createRandomArray(0, (int) Math.pow(10, 3), (int) Math.pow(10, 6));
        Integer[] arr2 = Random.createRandomArray(0, (int) Math.pow(10, 6), (int) Math.pow(10, 6));
        Integer[] arr3 = Random.createRandomArray(0, (int) Math.pow(10, 7), (int) Math.pow(10, 7));
        Integer[] arr4 = Random.createRandomArray(0, (int) Math.pow(10, 5), (int) Math.pow(10, 7));

        int k = 7;
        boolean flag = true;

        System.out.println("-------------------------");
        System.out.println("Range: 10^3" + ", Amount: 10^6");
        System.out.println("Right qsort");
        RunSort.RunRightSort(arr1);
        System.out.println("Combine qsort");
        checkCoefficient(arr1, k, flag);
        System.out.println("Random qsort");
        RunSort.RunRandomSort(arr1);
        System.out.println("-------------------------");
        System.out.println("Range: 10^6" + ", Amount: 10^6");
        System.out.println("Right qsort");
        RunSort.RunRightSort(arr2);
        System.out.println("Combine qsort");
        checkCoefficient(arr2, k, flag);
        System.out.println("Random qsort");
        RunSort.RunRandomSort(arr2);
        System.out.println("-------------------------");
        System.out.println("Range: 10^7" + ", Amount: 10^7");
        System.out.println("Right qsort");
        RunSort.RunRightSort(arr3);
        System.out.println("Combine qsort");
        checkCoefficient(arr3, k, flag);
        System.out.println("Random qsort");
        RunSort.RunRandomSort(arr3);
        System.out.println("-------------------------");
        System.out.println("Range: 10^5" + ", Amount: 10^7");
        System.out.println("Right qsort");
        RunSort.RunRightSort(arr4);
        System.out.println("Combine qsort");
        checkCoefficient(arr4, k, flag);
        System.out.println("Random qsort");
        RunSort.RunRandomSort(arr4);
    }
}
