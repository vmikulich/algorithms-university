package by.bsu.huffman.entity;

import java.util.Objects;

public class Node {

    private int value;
    private Node leftChild;
    private Node rightChild;
    private Node parentNode;

    public Node(int value) {
        this.value = value;
    }

    public boolean hasChild(Node node) {
        return leftChild == node || rightChild == node;
    }

    public boolean hasNoChild() {
        return leftChild == null && rightChild == null;
    }

    public int getValue() {
        return value;
    }

    public Node getLeftChild() {
        return leftChild;
    }

    public Node getRightChild() {
        return rightChild;
    }

    public Node getParentNode() {
        return parentNode;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void setLeftChild(Node leftChild) {
        this.leftChild = leftChild;
    }

    public void setRightChild(Node rightChild) {
        this.rightChild = rightChild;
    }

    public void setParentNode(Node parentNode) {
        this.parentNode = parentNode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return value == node.value &&
                Objects.equals(leftChild, node.leftChild) &&
                Objects.equals(rightChild, node.rightChild) &&
                Objects.equals(parentNode, node.parentNode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, leftChild, rightChild, parentNode);
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                ", leftChild=" + leftChild +
                ", rightChild=" + rightChild +
                ", parentNode=" + parentNode +
                '}';
    }
}
