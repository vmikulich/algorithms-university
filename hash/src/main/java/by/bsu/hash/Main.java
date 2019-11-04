package by.bsu.hash;

import by.bsu.hash.util.Avereges;
import by.bsu.hash.util.OutputInfo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        int value = 10;
        int size = 20013;
        int range = 40000;
        List<Integer[]> array = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            int randomKey = (int) Math.ceil(Math.random()*range);
            array.add(new Integer[]{randomKey, value});
        }

        System.out.println("**Кнут**");
        OutputInfo.outputInfo(size, array, Hash::hash3);
        System.out.println("----------------------------------------");
        System.out.println("**key % size**");
        OutputInfo.outputInfoWithConstant(size, array, Hash::hash2, Math.sqrt(15));
        System.out.println("----------------------------------------");
        System.out.println("**Math.sqrt(7)**");
        OutputInfo.outputInfoWithConstant(size, array, Hash::hash2, Math.sqrt(7));
        System.out.println("----------------------------------------");
        System.out.println("**Math.sqrt(2) % 5**");
        OutputInfo.outputInfoWithConstant(size, array, Hash::hash2, Math.sqrt(2) % 5);
    }
}
