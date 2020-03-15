package by.bsu.hash.util;

import by.bsu.hash.Hash;
import by.bsu.hash.HashChains;

import java.util.List;

public class OutputInfo {
    public static void outputInfo(int size, List<Integer[]> arr, hashFunc func) throws Exception{
        HashChains hashChains = new HashChains(size, func);
        for (int i = 0; i < size; i++) {
            hashChains.put(arr.get(i)[0], 10);
        }
        System.out.println("Average chain length: " + Avereges.getAverageChainLength(hashChains));
        System.out.println("Medium chain length: " + Avereges.getMediumChainLength(hashChains));
    }
    public static void outputInfoWithConstant(int size, List<Integer[]> arr, HashFuncWithConst func, Double constant) throws Exception{
        HashChains hashChains = new HashChains(size, func, constant);
        for (int i = 0; i < size; i++) {
            hashChains.put(arr.get(i)[0], 10);
        }
        System.out.println("Average chain length: " + Avereges.getAverageChainLength(hashChains));
        System.out.println("Medium chain length: " + Avereges.getMediumChainLength(hashChains));
    }
}
