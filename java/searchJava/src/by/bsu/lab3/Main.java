package by.bsu.lab3;

import by.bsu.lab3.BST.BinarySearchTree;
import by.bsu.lab3.BST.Node;
import by.bsu.lab3.binarySearch.BinarySearch;
import by.bsu.lab3.binarySearch.BinarySearchRecursive;
import by.bsu.lab3.interpolationSearch.InterpolationSearch;
import by.bsu.lab3.interpolationSearch.InterpolationSearchRecursive;

import java.util.Arrays;

import static by.bsu.lab3.binarySearch.BinarySearch.binarySearch;

public class Main {
    public static void main(String[] args) {
        Integer[] arr = Random.createRandomArray(0, 50, 30);
        System.out.println(Arrays.asList(arr));
        Run.runSearch(InterpolationSearch.interpolationSearch(arr, 6));
        Run.runSearch(BinarySearch.binarySearch(arr, 6));
//        System.out.println(Arrays.asList(InterpolationSearch.interpolationSearch(arr, 20)));
//        System.out.println(Arrays.asList(BinarySearch.binarySearch(arr, 20)));
//        Run.RunBinarySort(arr, 20);
//        Run.RunBinarySortRecursive(arr, 33);
//        Run.RunInterpolationSearch(arr, 20);
//        Run.RunInterpolationSearchRecursive(arr, 33);
//        System.out.println(binarySearch(arr, 100));
//        System.out.println(BinarySearchRecursive.binarySearch(arr, 100));
//        System.out.println(InterpolationSearch.interpolationSearch(arr, 5));
//        System.out.println(InterpolationSearchRecursive.interpolationSearch(arr, 5));
//        BinarySearchTree bst = new BinarySearchTree();
//        bst.addNode(50, bst.root());
//        bst.addNode(60, bst.root());
//        bst.addNode(40, bst.root());
//        bst.addNode(30, bst.root());
//        bst.addNode(45, bst.root());
//        bst.addNode(20, bst.root());
//        bst.addNode(35, bst.root());
//        bst.addNode(9);
//        bst.addNode(8);
//        bst.addNode(7);
//        bst.addNode(6);
//        bst.addNode(5);
//        bst.preOrderTraverseTree(bst.root());
    }
}
