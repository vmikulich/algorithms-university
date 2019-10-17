package by.bsu.lab3;

import by.bsu.lab3.BST.BinarySearchTree;
import by.bsu.lab3.BST.Node;
import by.bsu.lab3.binarySearch.BinarySearchRecursive;
import by.bsu.lab3.interpolationSearch.InterpolationSearch;
import by.bsu.lab3.interpolationSearch.InterpolationSearchRecursive;

import static by.bsu.lab3.binarySearch.BinarySearch.binarySearch;

public class Main {
    public static void main(String[] args) {
        Integer[] arr = {1, 2, 4, 6, 13, 20, 21, 33, 43, 55, 100};
//        System.out.println(binarySearch(arr, 100));
//        System.out.println(BinarySearchRecursive.binarySearch(arr, 100));
//        System.out.println(InterpolationSearch.interpolationSearch(arr, 5));
//        System.out.println(InterpolationSearchRecursive.interpolationSearch(arr, 5));
        BinarySearchTree bst = new BinarySearchTree();
        bst.addNode(50, bst.root);
        bst.addNode(60, bst.root);
        bst.addNode(40, bst.root);
        bst.addNode(30, bst.root);
        bst.addNode(45, bst.root);
        bst.addNode(20, bst.root);
        bst.addNode(35, bst.root);
//        bst.preOrderTraverseTree(bst.root);
//        bst.preOrderTraverseTree(bst.root);
//        System.out.println(bst.leftRotation(bst.root));
//        bst.preOrderTraverseTree(bst.root);
//        bst.inOrderTraverseTree(bst.root);
//        System.out.println("------------------");
//        bst.inReverseOrderTraverseTree(bst.root);
        System.out.println("------------------");
        System.out.println(bst.findNode(60));
        System.out.println(bst.findNode(12));
//        System.out.println("------------------");
//        System.out.println(bst.kMinimumNode(4));
    }
}
