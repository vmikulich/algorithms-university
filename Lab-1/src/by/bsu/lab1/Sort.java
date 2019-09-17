package by.bsu.lab1;

import java.util.Arrays;

public class Sort {

    public static Integer[] insertionSorting(Integer[] arr) {
        for(int i = 1; i < arr.length; i++) {
            if (arr.length == 0) {
                return null;
            }
            for (int j = i; j > 0 && arr[j] < arr[j - 1] ; j--) {
                swap(arr, j, j - 1);
            }
        }

        return arr;
    }

    public static void swap(Integer[] arr, int firstIndex, int secondIndex) {
        int temp = arr[firstIndex];
        arr[firstIndex] = arr[secondIndex];
        arr[secondIndex] = temp;
    }


    public static void main(String[] args) {
        Integer[] arr = {73, 19, 44, 32, 70, 37, 38, 25, 39, 1};
        System.out.println(Arrays.asList(insertionSorting(arr)));
    }

}
