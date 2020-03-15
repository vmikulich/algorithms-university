package by.bsu.lab1.utils;

public class Random {
    public static Integer[] createRandomArray(int min, int max, int amount) {
        Integer[] array = new Integer[amount];
        for (int i = 0; i < amount; i++) {
            array[i] = (int) Math.round((Math.random() * (max - min + 1)) + min);
        }
        return array;
    }
}
