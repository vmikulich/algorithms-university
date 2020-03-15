package by.bsu.hash.util;

import by.bsu.hash.HashChains;
import by.bsu.hash.entry.Entry;

import java.util.Arrays;
import java.util.LinkedList;

public class Avereges {
    public static double getAverageChainLength(HashChains map) {
        LinkedList<Entry>[] lists = map.lists;
        double elems = 0;
        int count = 0;
        for (LinkedList<Entry> list: lists) {
            if (list != null) {
                elems += list.size();
                if (list.size() > 0) {
                    count++;
                }
            }
        }
        return elems / count;
    }

    public static double getMediumChainLength(HashChains map) {
        LinkedList<Entry>[] lists = map.lists;
        Arrays.sort(lists, new SortByLenght());
        return lists[lists.length / 2].size();
    }


}
