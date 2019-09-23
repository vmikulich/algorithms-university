package by.bsu.lab1.utils;

public class Separartor {
    public static int getSeparatorByFlag(boolean flag, Integer[] arr, int end, int begin){
        return flag ? arr[end] : arr[(int) Math.ceil(Math.random()*(end - begin) + begin)];
    }
}
