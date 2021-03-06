package by.bsu.lab3.binarySearch;

public class BinarySearch {
    public static Integer[] binarySearch(Integer[] arr, int elemToSearch) {
        int count = 0;
        int index = -1;
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = start + ((end - start) / 2);
            if (arr[mid] == elemToSearch) {
                index = mid;
                break;
            } else if (elemToSearch < arr[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
            count++;
        }
        return new Integer[]{index, count};
    }
}
