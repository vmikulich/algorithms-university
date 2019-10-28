package by.bsu.lab3.interpolationSearch;

public class InterpolationSearch {
    public static Integer[] interpolationSearch(Integer[] arr, int elemToSearch) {
        int count = 0;
        int index = -1;
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int pos = start + (((end - start) * (elemToSearch - arr[start])) / (arr[end] - arr[start]));
            if (arr[pos] == elemToSearch) {
                index = pos;
                break;
            } else if (elemToSearch < arr[pos]) {
                end = pos - 1;
            } else {
                start = pos + 1;
            }
            count++;
        }
        return new Integer[]{index, count};
    }
}
