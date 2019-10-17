package by.bsu.lab3.sequentialSearch;

public class SequentialSearch {
    public static int sequentialSearch(Integer[] arr, double elemToSearch) {
        int index = -1;
        for (int i = 0; i < arr.length; i++) {
            if (elemToSearch == arr[i]) {
                index = i;
                break;
            }
        }
        return index;
    }
}



