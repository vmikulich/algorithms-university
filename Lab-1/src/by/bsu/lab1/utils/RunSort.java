package by.bsu.lab1.utils;

import by.bsu.lab1.action.RandomSort;
import by.bsu.lab1.action.RightSort;

import java.util.Date;


public class RunSort {
    public static void RunRightSort (Integer[] arr) {
        long prevTime = 99999999;
        while (true) {
            Integer[] arrCopy = arr.clone();
            Date date = new Date();
            long first = date.getTime();
            RightSort.rightSort(arrCopy, 0, arr.length - 1);
            long time = new Date().getTime() - first;
            if (time > prevTime) {
                System.out.println("Time: " + prevTime);
                break;
            }
            prevTime = time;
        }
    }

    public static void RunRandomSort (Integer[] arr) {
        long prevTime = 99999999;
        while (true) {
            Integer[] arrCopy = arr.clone();
            Date date = new Date();
            long first = date.getTime();
            RandomSort.randomSort(arrCopy, 0, arr.length - 1);
            long time = new Date().getTime() - first;
            if (time > prevTime) {
                System.out.println("Time: " + prevTime);
                break;
            }
            prevTime = time;
        }
    }
}
