package by.bsu.lab6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TaskSolver {
    public static Integer robot(int size) {
        Integer[][] matrix = new Integer[size][size];
        matrix[size - 1][0] = 0;
        for (int i = 0; i < size; i++) {
            Arrays.fill(matrix[i], 1);
        }
        for (int i = size - 2; i >= 0; i--) {
            for (int j = 1; j < size; j++) {
                matrix[i][j] = matrix[i][j - 1] + matrix[i + 1][j];
            }
        }
        return matrix[0][size - 1];
    }

    public static void main(String[] args) {
        System.out.println(robot(20));
    }
}
