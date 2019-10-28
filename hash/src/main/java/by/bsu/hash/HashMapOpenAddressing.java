package by.bsu.hash;

import by.bsu.hash.entry.Entry;
import by.bsu.hash.util.WorkWithSize;

import java.util.Arrays;
import java.util.HashSet;

public class HashMapOpenAddressing {
    int size;
    Entry[] arrOfElements;
    HashSet<Integer> keys = new HashSet<>();

    public HashMapOpenAddressing(int size) {
        this.size = WorkWithSize.isPrime(size) ? size : WorkWithSize.getNextPrime(size);
        this.arrOfElements = new Entry[this.size];
    }

    public void put(int key, int value) throws Exception {
        if (keys.contains(key)) {
            throw new Exception("Such element is already exist");
        }
        Entry newElem = new Entry(key, value);
        int index = Hash.hash1(key, size);
        int coef = 4;
        int step = coef - key % coef;
        while(arrOfElements[index] != null) {
            index += step;
            index %= size;
        }
        arrOfElements[index] = newElem;
        keys.add(key);
    }

    public Integer get(int key) {
        int res = 0;
        if(!keys.contains(key)) {
            return null;
        }
        int index = Hash.hash1(key, size);
        int coef = 4;
        int step = coef - key % coef;
        while (arrOfElements[index] != null) {
            if (arrOfElements[index].getKey() == key) {
                res = arrOfElements[index].getValue();
                break;
            }
            index += step;
        }
        return res;
    }

//    public static void main(String[] args) throws Exception{
//        HashMapOpenAddressing map = new HashMapOpenAddressing(30);
//        map.put(1, 2);
//        map.put(2, 21);
//        map.put(5, 3);
//        map.put(31, 24);
//        map.put(32, 7);
//        map.put(8, 9);
//        map.put(33, 19);
////        System.out.println(Arrays.asList(map.arrOfElements));
//        System.out.println(map.get(33));
//    }
}
