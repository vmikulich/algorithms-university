package by.bsu.lab3.BST;

public class Node {
    int key;

    Node leftChild;
    Node rightChild;

    public Node(int key) {
        this.key = key;
    }

    @Override
    public String toString() {
        return "" + key;
    }
}
