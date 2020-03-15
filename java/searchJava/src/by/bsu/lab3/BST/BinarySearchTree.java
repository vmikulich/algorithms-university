package by.bsu.lab3.BST;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class BinarySearchTree {

   Node root;

   public void addNode(int key) {
       addNode(key, root);
   }

    private void addNode(int key, Node focusNode) {
        Node newNode = new Node(key);
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

    public Node root() {
        return root;
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
            System.out.println("Node: " + focusNode);
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
        kMinimumNode(focusNode, bst);
        return bst.get(k);
    }

    private void kMinimumNode(Node focusNode, List<Node> bst) {
        if (focusNode == null) {
            return;
        }
        kMinimumNode(focusNode.leftChild, bst);
        bst.add(focusNode);
        kMinimumNode(focusNode.rightChild, bst);
    }

    public Node findParent(int childKey) {
        return findParent(childKey, root);
    }

    private Node findParent(int childKey, Node focusNode) {
        if (focusNode == null) {
            return null;
        } else if (childKey < focusNode.key) {
          if (focusNode.leftChild != null && focusNode.leftChild.key == childKey) {
              return focusNode;
          } else {
              return findParent(childKey, focusNode.leftChild);
          }
        } else {
            if (focusNode.rightChild != null && focusNode.rightChild.key == childKey) {
                return focusNode;
            } else {
                return findParent(childKey, focusNode.rightChild);
            }
        }
    }


    public Node leftRotation(Node focusNode) {
        Node tmp = focusNode.rightChild;
        focusNode.rightChild = tmp.leftChild;
        tmp.leftChild = focusNode;
        Node parentOfTmp = findParent(focusNode.key, root);
        if (parentOfTmp != null) {
            parentOfTmp.rightChild = tmp;
        }
        if (focusNode == root) {
            root = tmp;
        }
        return tmp;
    }

    public Node rightRotation(Node focusNode) {
        Node tmp = focusNode.leftChild;
        focusNode.leftChild = tmp.rightChild;
        tmp.rightChild = focusNode;
        Node parentOfTmp = findParent(focusNode.key, root);
        if (parentOfTmp != null) {
            parentOfTmp.leftChild = tmp;
        }
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

    public boolean remove(int key) {
        if (findNode(key) != null) {
            remove(root, key);
            return true;
        }
        return false;
    }

    private Node remove(Node focusNode, int key) {
        if (focusNode == null){
            return null;
        }
        if (key < focusNode.key) {
            focusNode.leftChild = remove(focusNode.leftChild, key);
            focusNode = balance(focusNode);
        } else if (key > focusNode.key) {
            focusNode.rightChild = remove(focusNode.rightChild, key);
            focusNode = balance(focusNode);
        } else {
            if (focusNode.leftChild == null) {
                return focusNode.rightChild;
            } else if (focusNode.rightChild == null) {
                return focusNode.leftChild;
            } else {
                if (differenceOfDepth(focusNode) > 1) {
                    int successorKey = findMax(focusNode.leftChild);
                    System.out.println("l " + successorKey);
                    focusNode.key = successorKey;
                    focusNode.leftChild = remove(focusNode.leftChild, successorKey);
                } else {
                    int successorKey = findMin(focusNode.rightChild);
                    System.out.println("r " + successorKey);
                    focusNode.key = successorKey;
                    focusNode.rightChild = remove(focusNode.rightChild, successorKey);
                }
            }
        }
        return balance(focusNode);
    }


    public Node placeInRoot(int key, Node focusNode) {
        if (focusNode == null || (focusNode.leftChild == null && focusNode.rightChild == null)) {
            return null;
        }
        Node parent = findParent(key);
        Node node = findNode(key);
        while (!focusNode.hasChild(focusNode) && parent != null) {
            node = node.key < parent.key ? rightRotation(parent) : leftRotation(parent);
            parent = findParent(node.key);
        }
        return node;
    }

    private int findMin(Node focusNode) {
        while (focusNode.leftChild != null) focusNode = focusNode.leftChild;
        return focusNode.key;
    }

    private int findMax(Node focusNode) {
        while (focusNode.rightChild != null) focusNode = focusNode.rightChild;
        return focusNode.key;
    }
}
