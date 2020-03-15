package by.bsu.stableMarriageProblem;

public class Main {
    public static void main(String[] args) {
        Integer[][] priorities = {
                {1,0,2,3,4},
                {4,1,2,3,0},
                {2,3,1,0,4},
                {1,4,3,2,0},
                {2,0,4,1,3}
        };

        Integer[][] estimations = {
                {12,8,3,5,10},
                {11,13,7,9,10},
                {14,10,9,5,8},
                {13,14,10,8,11},
                {11,13,14,9,15}
        };
        StableMarriageProblem1.stableMarriageProblem(estimations, priorities);
    }
}
