package by.bsu.lab3;

public class Random {
    public static Integer[] createRandomArray(int min, int max, int amount) {
        Integer[] array = new Integer[amount];
        array[0] = (int) Math.round((Math.random() * (max - min + 1)) + min);
        for (int i = 1; i < amount; i++) {
            int num = (int) Math.round((Math.random() * (max - min + 1)) + min);
            while(num <= array[i - 1]) {
                System.out.println(num);
                num = (int) Math.round((Math.random() * (max - min + 1)) + min);
                if (num > array[i - 1]) break;
            }
            array[i] = num;
        }
        return array;
    }
}
