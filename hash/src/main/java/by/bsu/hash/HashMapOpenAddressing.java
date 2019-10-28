package by.bsu.hash;

import by.bsu.hash.entry.Entry;

import java.util.Arrays;
import java.util.HashSet;

public class HashMapOpenAddressing {
    int size;
    Entry[] arrOfElements;
    HashSet<Integer> keys = new HashSet<>();

    public HashMapOpenAddressing(int size) {
        this.size = size;
        this.arrOfElements = new Entry[size];
    }

    public void put(int key, int value) throws Exception {
        if (keys.contains(key)) {
            throw new Exception("Such element is already exist");
        }
        Entry newElem = new Entry(key, value);
        int index = Hash.hash1(key, size);
        while(arrOfElements[index] != null) {
            index++;
            index %= size;
        }
        arrOfElements[index] = newElem;
        keys.add(key);
    }

    public int get(int key) {
        int res = -1;
        if(!keys.contains(key)) {
            return res;
        }
        int index = Hash.hash1(key, size);
        while (arrOfElements[index] != null) {
            if (arrOfElements[index].getKey() == key) {
                res = arrOfElements[index].getValue();
                break;
            }
        }
        return res;
    }

    public static void main(String[] args) throws Exception{
        HashMapOpenAddressing f = new HashMapOpenAddressing(9);
        f.put(1, 2);
        f.put(3, 4);
        f.put(8, 7);
        f.put(18, 90);
        f.put(19, 91);
        System.out.println(Arrays.asList(f.arrOfElements));
    }
}
