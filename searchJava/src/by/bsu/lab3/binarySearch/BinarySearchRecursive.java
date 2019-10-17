package by.bsu.lab3.binarySearch;

public class BinarySearchRecursive {
    public static int binarySearch(Integer[] arr, int elem) {
        return doSearch(arr, elem, 0, arr.length - 1);
    }

    public static int doSearch(Integer[] arr, int elem, int start, int end) {
        if (start > end) {
            return -1;
        }
        int mid = start + ((end - start) / 2);
        if (arr[mid] == elem) {
            return mid;
        } else if (elem < arr[mid]) {
            return doSearch(arr, elem, start, mid - 1);
        } else {
            return doSearch(arr, elem, mid + 1, end);
        }
    }
}
