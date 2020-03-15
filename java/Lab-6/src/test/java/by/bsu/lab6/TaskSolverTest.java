package by.bsu.lab6;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.junit.runner.RunWith;


//@RunWith(DataProviderRunner.class)
public class TaskSolverTest {

    @Test
    public void robotTest() {
        assertEquals(TaskSolver.robot(4), 20);
        assertEquals(TaskSolver.robot(5), 70);
        assertEquals(TaskSolver.robot(20), 985525432);
    }


//    @DataProvider
//    public static Object[][] data() {
//        return new Object[][] {
//                { 20, 4 },
//                { 70, 5 },
//        };
//    }
//
//    @Test
//    @UseDataProvider("data")
//    public void robotTest(int input, int expected) {
//        assertEquals(expected, TaskSolver.robot(input));
//    }
}
