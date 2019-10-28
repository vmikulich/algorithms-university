package by.bsu.hash;

import by.bsu.hash.entry.Entry;
import by.bsu.hash.util.WorkWithSize;

import java.util.*;

public class HashChains {

    int size;
    HashSet<Integer> keys = new HashSet<>();
    LinkedList<Entry>[] lists;

    public HashChains(int size) {
        this.size = WorkWithSize.isPrime(size) ? size : WorkWithSize.getNextPrime(size);
        this.lists = new LinkedList[this.size];
    }

    public void put(int key, int value) throws Exception {
        if (keys.contains(key)) {
            throw new Exception("Such element is already exist");
        }
        Entry newElem = new Entry(key, value);
        int index = Hash.hash1(key, size);
        if (lists[index] == null) {
            lists[index] = new LinkedList<>();
        }
        lists[index].add(newElem);
        keys.add(key);
    }

    public Integer get(int key) {
        int res = 0;
        if (!keys.contains(key)) {
            return null;
        }
        int index = Hash.hash1(key, size);
        LinkedList<Entry> list = lists[index];
        for (Entry entry: list) {
            if (entry.getKey() == key) {
                res = entry.getValue();
                break;
            }
        }
        return res;
    }
}
