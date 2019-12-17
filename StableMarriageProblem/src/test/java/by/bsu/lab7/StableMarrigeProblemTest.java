package by.bsu.lab7;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class StableMarrigeProblemTest {
    @Test
    public void test1() {
        Integer men[][] = {
                {1,0,2,3,4},
                {4,3,2,1,0},
                {3,2,1,0,4},
                {1,4,3,2,0},
                {2,0,4,1,3}
        };
        Integer women[][] = {
                {4,0,1,2,3},
                {3,4,0,1,2},
                {2,3,4,0,1},
                {1,2,3,4,0},
                {0,1,2,3,4}
        };

        assertEquals(StableMarriageProblem.stableMarriageProblem(men, women).get(0), 0);
        assertEquals(StableMarriageProblem.stableMarriageProblem(men, women).get(1), 3);
        assertEquals(StableMarriageProblem.stableMarriageProblem(men, women).get(2), 4);
        assertEquals(StableMarriageProblem.stableMarriageProblem(men, women).get(3), 2);
        assertEquals(StableMarriageProblem.stableMarriageProblem(men, women).get(4), 1);
    }

    @Test
    public void test2() {
        Integer men[][] = {
                {3,1,2,1,4},
                {3,4,2,1,0},
                {3,2,1,0,4},
                {1,4,3,2,0},
                {2,0,4,1,3}
        };
        Integer women[][] = {
                {4,0,1,2,3},
                {3,4,0,1,2},
                {2,3,4,0,1},
                {1,2,3,4,0},
                {3,1,2,0,4}
        };

        assertEquals(StableMarriageProblem.stableMarriageProblem(men, women).get(0), 4);
        assertEquals(StableMarriageProblem.stableMarriageProblem(men, women).get(1), 3);
        assertEquals(StableMarriageProblem.stableMarriageProblem(men, women).get(2), 2);
        assertEquals(StableMarriageProblem.stableMarriageProblem(men, women).get(3), 1);
        assertEquals(StableMarriageProblem.stableMarriageProblem(men, women).get(4), 0);
    }
}
