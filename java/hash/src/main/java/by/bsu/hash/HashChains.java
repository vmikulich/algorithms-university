package by.bsu.hash;

import by.bsu.hash.entry.Entry;
import by.bsu.hash.util.HashFuncWithConst;
import by.bsu.hash.util.WorkWithSize;
import by.bsu.hash.util.hashFunc;
import java.util.*;

public class HashChains {

    int size;
    public LinkedList<Entry>[] lists;
    hashFunc func;
    HashFuncWithConst funcWithConst;
    Double constant = Double.NaN;

    public HashChains(int size, hashFunc func) {
        this.size = WorkWithSize.isPrime(size) ? size : WorkWithSize.getNextPrime(size);
        this.lists = new LinkedList[this.size];
        this.func = func;
    }
    public HashChains(int size, HashFuncWithConst func, Double constant) {
        this.size = WorkWithSize.isPrime(size) ? size : WorkWithSize.getNextPrime(size);
        this.lists = new LinkedList[this.size];
        this.funcWithConst = func;
        this.constant = constant;
    }

    public void put(int key, int value) throws Exception {
        Entry newElem = new Entry(key, value);
        int index;
        if (constant.isNaN()) {
            index = func.hashFunc(key, size);
        } else {
            index = funcWithConst.hashFunc(key, size, constant);
        }
        if (lists[index] == null) {
            lists[index] = new LinkedList<>();
        }
        if (lists[index].contains(newElem.getKey())) {
            throw new Exception("Such element is already exist");
        }
        lists[index].add(newElem);
    }

    public Integer get(int key) {
        int res = 0;
        int index = Hash.hash1(key, size);
        LinkedList<Entry> list = lists[index];
        if (lists[index] == null) {
            return null;
        }
        for (Entry entry: list) {
            if (entry.getKey() == key) {
                res = entry.getValue();
            }
        }
        return res;
    }
}
