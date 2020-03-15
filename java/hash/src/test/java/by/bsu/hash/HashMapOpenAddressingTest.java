package by.bsu.hash;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HashMapOpenAddressingTest {
    HashMapOpenAddressing map = new HashMapOpenAddressing(31);

    @BeforeEach
    public void initialization() throws Exception{
        map.put(1, 2);
        map.put(2, 21);
        map.put(5, 3);
        map.put(31, 24);
        map.put(32, 7);
        map.put(8, 9);
        map.put(33, 19);
    }

    @Test
    public void testPut() {
        assertEquals(map.arrOfElements[1].getValue(), 2);
        assertEquals(map.arrOfElements[2].getValue(), 21);
        assertEquals(map.arrOfElements[0].getValue(), 24);
        assertEquals(map.arrOfElements[9].getValue(), 7);
        assertEquals(map.arrOfElements[11].getValue(), 19);
        assertEquals(map.arrOfElements[5].getValue(), 3);
        assertEquals(map.arrOfElements[8].getValue(), 9);
    }

    @Test
    public void testGet() {
        assertEquals(19, map.get(33));
        assertEquals(2, map.get(1));
        assertEquals(7, map.get(32));
        assertEquals(null, map.get(50));
    }
}
