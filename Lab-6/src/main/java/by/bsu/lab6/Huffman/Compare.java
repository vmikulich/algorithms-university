package by.bsu.lab6.Huffman;


import java.util.Comparator;

public class Compare implements Comparator<Node> {
    @Override
    public int compare(Node a, Node b) {
        return b.getFrequency().compareTo(a.getFrequency());
    }
}
