package by.bsu.lab3.BST;

public class Node {
    int key;

    Node leftChild;
    Node rightChild;

    public Node(int key) {
        this.key = key;
    }
    public boolean hasChild(Node node) {
        return leftChild == node || rightChild == node;
    }

    @Override
    public String toString() {
        return "" + key;
    }
}
