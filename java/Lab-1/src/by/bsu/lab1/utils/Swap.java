package by.bsu.lab1.utils;

public class Swap {
    public static void swap(Integer[] arr, int firstIndex, int secondIndex) {
        int temp = arr[firstIndex];
        arr[firstIndex] = arr[secondIndex];
        arr[secondIndex] = temp;
    }
}
