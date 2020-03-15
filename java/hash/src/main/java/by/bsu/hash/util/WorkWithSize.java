package by.bsu.hash.util;

public class WorkWithSize {
    public static boolean isPrime(int number) {
        if (number % 2 == 0) {
            return false;
        }
        for (int i = 3; i * i < number; i+=2) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static int getNextPrime(int numberToCheck) {
        for(int i = numberToCheck; true; i++) {
            if (isPrime(i))
                return i;
        }
    }

//    public static void increaseArraySize(int arraySize) {
//        int newArraySize = getNextPrime(arraySize);
//        moveOldArray(newArraySize);
//    }

}
