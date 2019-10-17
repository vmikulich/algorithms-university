package by.bsu.lab3.interpolationSearch;

public class InterpolationSearchRecursive {
    public static int interpolationSearch(Integer[] arr, int elemToSearch) {
        return doSearch(arr, elemToSearch, 0, arr.length - 1);
    }

    public static int doSearch(Integer[] arr, int elemToSearch, int start, int end) {
        if (start > end) {
            return -1;
        }
        int pos = start + (((end - start) * (elemToSearch - arr[start])) / (arr[end] - arr[start]));
        if (arr[pos] == elemToSearch) {
            return pos;
        } else if (elemToSearch < arr[pos]) {
            return doSearch(arr, elemToSearch, start, pos - 1);
        } else {
            return doSearch(arr, elemToSearch, pos + 1, end);
        }
    }
}
