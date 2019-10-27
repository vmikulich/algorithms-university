package by.bsu.hash;

import org.junit.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HashMapChainsTest {


    HashChains hashChains = new HashChains(31);

    @BeforeEach
    public void initialization() throws Exception{
        hashChains.put(1, 2);
        hashChains.put(2, 21);
        hashChains.put(5, 3);
        hashChains.put(31, 24);
        hashChains.put(32, 7);
        hashChains.put(8, 9);
        hashChains.put(33, 19);
    }

    @Test
    public void testPut() {
        assertEquals(hashChains.lists[1].get(0).getValue(), 2);
        assertEquals(hashChains.lists[5].get(0).getValue(), 3);
        assertEquals(hashChains.lists[0].get(0).getValue(), 24);
        assertEquals(hashChains.lists[1].get(1).getValue(), 7);
        assertEquals(hashChains.lists[8].get(0).getValue(), 9);
        assertEquals(hashChains.lists[2].get(0).getValue(), 21);
        assertEquals(hashChains.lists[2].get(1).getValue(), 19);
    }

    @Test
    public void testGet() {
        assertEquals(19, hashChains.get(33));
        assertEquals(2, hashChains.get(1));
        assertEquals(7, hashChains.get(32));
        assertEquals(-1, hashChains.get(50));
    }
}
