package by.bsu.lab3.binarySearch;

public class BinarySearchRecursive {
    public static int[] binarySearch(Integer[] arr, int elem) {
        int count = 0;
        return doSearch(arr, elem, 0, arr.length - 1, count);
    }

    public static int[] doSearch(Integer[] arr, int elem, int start, int end, int count) {
        if (start > end) {
            return new int[]{-1, count};
        }
        int mid = start + ((end - start) / 2);
        if (arr[mid] == elem) {
            return new int[]{mid, count};
        } else if (elem < arr[mid]) {
            return doSearch(arr, elem, start, mid - 1, count++);
        } else {
            return doSearch(arr, elem, mid + 1, end, count++);
        }
    }
}
