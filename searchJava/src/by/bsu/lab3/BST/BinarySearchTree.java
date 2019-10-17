package by.bsu.lab3.BST;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class BinarySearchTree {

   public Node root;

    public void addNode(int key, Node focusNode) {
        Node newNode = new Node(key);
//        if (root == null) {
//            root = newNode;
//        } else {
//            Node focusNode = root;
//            Node parent;
//            while (true) {
//                parent = focusNode;
//                if (key < focusNode.key) {
//                    focusNode = focusNode.leftChild;
//                    if (focusNode == null) {
//                        parent.leftChild = newNode;
//                        return;
//                    }
//                } else {
//                    focusNode = focusNode.rightChild;
//                    if (focusNode == null) {
//                        parent.rightChild = newNode;
//                        return;
//                    }
//                }
//            }
//        }
        if (root == null) {
            root = newNode;
        } else {
            if (key < focusNode.key) {
                if (focusNode.leftChild != null) {
                    addNode(key, focusNode.leftChild);
                    focusNode = balance(focusNode);
                } else {
                    focusNode.leftChild = newNode;
                }
            } else {
                if (focusNode.rightChild != null) {
                    addNode(key, focusNode.rightChild);
                    focusNode = balance(focusNode);
                } else {
                    focusNode.rightChild = newNode;
                }
            }
        }
    }

    public void inOrderTraverseTree(Node focusNode) {
        if(focusNode != null) {
            inOrderTraverseTree(focusNode.leftChild);
            System.out.println(focusNode);
            inOrderTraverseTree(focusNode.rightChild);
        }
    }

    public void inReverseOrderTraverseTree(Node focusNode) {
        if(focusNode != null) {
            inReverseOrderTraverseTree(focusNode.rightChild);
            System.out.println(focusNode);
            inReverseOrderTraverseTree(focusNode.leftChild);
        }
    }

    public void preOrderTraverseTree(Node focusNode) {
        if(focusNode != null) {
            System.out.println("Parent: " + focusNode);
            System.out.println("Left child: " + focusNode.leftChild);
            System.out.println("Right child: " + focusNode.rightChild);
            System.out.println("-----------------");
            preOrderTraverseTree(focusNode.leftChild);
            preOrderTraverseTree(focusNode.rightChild);
        }
    }


    public Node findNode(int key) {
        Node focusNode = root;
        while (focusNode.key != key) {
            if (key < focusNode.key) {
                focusNode = focusNode.leftChild;
            } else {
                focusNode = focusNode.rightChild;
            }
            if (focusNode == null) {
                return null;
            }
        }
        return focusNode;
    }

    public Node kMinimumNode(int k) {
        Node focusNode = root;
        List<Node> bst = new ArrayList();
        doKminimumNode(focusNode, bst);
//        System.out.println(bst.get(k));
        return bst.get(k);
    }

    void doKminimumNode(Node focusNode, List<Node> bst) {
        if (focusNode == null) {
            return;
        }
        doKminimumNode(focusNode.leftChild, bst);
        bst.add(focusNode);
        doKminimumNode(focusNode.rightChild, bst);
    }

    public Node leftRotation(Node focusNode) {
        Node tmp = focusNode.rightChild;
        focusNode.rightChild = tmp.leftChild;
        tmp.leftChild = focusNode;
        if (focusNode == root) {
            root = tmp;
        }
        return tmp;
    }

    public Node rightRotation(Node focusNode) {
        Node tmp = focusNode.leftChild;
        focusNode.leftChild = tmp.rightChild;
        tmp.rightChild = focusNode;
        if (focusNode == root) {
            root = tmp;
        }
        return tmp;
    }

    public Node rightLeftRotation(Node focusNode) {
        focusNode.rightChild = rightRotation(focusNode.rightChild);
        return leftRotation(focusNode);
    }

    public Node leftRightRotation(Node focusNode) {
        focusNode.leftChild = leftRotation(focusNode.leftChild);
        return rightRotation(focusNode);
    }

    public int depth(Node focusNode) {
        if (focusNode == null) {
            return 0;
        }
        return 1 + Math.max(depth(focusNode.leftChild), depth(focusNode.rightChild));
    }

    public int differenceOfDepth(Node focusNode) {
        return depth(focusNode.leftChild) - depth(focusNode.rightChild);
    }

    public Node balance(Node focusNode) {
        int factor = differenceOfDepth(focusNode);
//        System.out.println(factor);
        if (factor > 1) {
            if (differenceOfDepth(focusNode.leftChild) > 0) {
                focusNode = rightRotation(focusNode);
            } else {
                focusNode = leftRightRotation(focusNode);
            }
        } else if (factor < -1){
            if (differenceOfDepth(focusNode.rightChild) > 0) {
                focusNode = rightLeftRotation(focusNode);
            } else {
                focusNode = leftRotation(focusNode);
            }
        }
        return focusNode;
    }
}
