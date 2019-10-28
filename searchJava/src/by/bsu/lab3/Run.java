package by.bsu.lab3;

import by.bsu.lab3.binarySearch.BinarySearch;
import by.bsu.lab3.binarySearch.BinarySearchRecursive;
import by.bsu.lab3.interpolationSearch.InterpolationSearch;
import by.bsu.lab3.interpolationSearch.InterpolationSearchRecursive;

import java.util.Date;


public class Run {
    public static void runSearch(Integer[] arr) {
        System.out.println("Index of element: " + arr[0]);
        System.out.println("Count of iterations: " + arr[1]);
    }

//    public static void RunInterpolationSearch (Integer[] arr, int elem) {
//        Integer[] arrCopy = arr.clone();
//        int[] res = InterpolationSearch.interpolationSearch(arrCopy, elem);
//        System.out.println("Count of iterations: " + res[1]);
//    }
//
//    public static void RunBinarySort (Integer[] arr, int elem) {
//        Integer[] arrCopy = arr.clone();
//        int[] res = BinarySearch.binarySearch(arrCopy, elem);
//        System.out.println("Count of iterations: " + res[1]);
//    }
//
//    public static void RunBinarySortRecursive (Integer[] arr, int elem) {
//        Integer[] arrCopy = arr.clone();
//        int[] res = InterpolationSearch.interpolationSearch(arrCopy, elem);
//        System.out.println("Count of iterations: " + res[1]);
//    }
//
//    public static void RunInterpolationSearchRecursive (Integer[] arr, int elem) {
//        Integer[] arrCopy = arr.clone();
//        int[] res = InterpolationSearch.interpolationSearch(arrCopy, elem);
//        System.out.println("Count of iterations: " + res[1]);
//    }
}
