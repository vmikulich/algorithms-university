package by.bsu.lab1;

import by.bsu.lab1.utils.Random;

import static by.bsu.lab1.utils.CheckCoefficient.checkCoefficient;

public class Main {
    public static void main(String[] args) {
        Integer[] arr1 = Random.createRandomArray(0, (int) Math.pow(10, 3), (int) Math.pow(10, 6));
        Integer[] arr2 = Random.createRandomArray(0, (int) Math.pow(10, 6), (int) Math.pow(10, 6));
        Integer[] arr3 = Random.createRandomArray(0, (int) Math.pow(10, 7), (int) Math.pow(10, 7));
        Integer[] arr4 = Random.createRandomArray(0, (int) Math.pow(10, 5), (int) Math.pow(10, 7));

        int k = 7;

        System.out.println("-------------------------");
        System.out.println("Range: 10^3" + ", Amount: 10^6");
        checkCoefficient(arr1, k);
        System.out.println("-------------------------");
        System.out.println("Range: 10^6" + ", Amount: 10^6");
        checkCoefficient(arr2, k);
        System.out.println("-------------------------");
        System.out.println("Range: 10^7" + ", Amount: 10^7");
        checkCoefficient(arr3, k);
        System.out.println("-------------------------");
        System.out.println("Range: 10^5" + ", Amount: 10^7");
        checkCoefficient(arr4, k);
    }
}
