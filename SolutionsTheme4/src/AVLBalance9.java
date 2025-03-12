import java.io.*;
import java.util.*;

class AVLTree {
    static class Node {
        int key;
        Node left, right;

        Node(int key) {
            this.key = key;
            left = right = null;
        }
    }

    private Node root;

    public void insert(int key) {
        root = insert(root, key);
    }

    private Node insert(Node node, int key) {
        if (node == null) return new Node(key);

        if (key < node.key)
            node.left = insert(node.left, key);
        else if (key > node.key)
            node.right = insert(node.right, key);

        return node;
    }

    public boolean isBalanced() {
        return checkBalance(root) != -1;
    }

    private int checkBalance(Node node) {
        if (node == null) return 0;

        int leftHeight = checkBalance(node.left);
        int rightHeight = checkBalance(node.right);

        if (leftHeight == -1 || rightHeight == -1 || Math.abs(leftHeight - rightHeight) > 1)
            return -1;

        return Math.max(leftHeight, rightHeight) + 1;
    }
}

public class AVLBalance9 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        AVLTree tree = new AVLTree();
        String[] input = reader.readLine().split(" ");

        for (String num : input) {
            int value = Integer.parseInt(num);
            if (value == 0) break;
            tree.insert(value);
        }

        writer.write(tree.isBalanced() ? "YES\n" : "NO\n");

        reader.close();
        writer.close();
    }
}