import java.io.*;
import java.util.*;

public class OutputOfBranches8 {

    static class Node {
        int value;
        Node left, right;

        Node(int value) {
            this.value = value;
        }
    }

    static class BST {
        Node root;

        void insert(int value) {
            root = insertRec(root, value);
        }

        private Node insertRec(Node node, int value) {
            if (node == null) {
                return new Node(value);
            }
            if (value < node.value) {
                node.left = insertRec(node.left, value);
            } else if (value > node.value) {
                node.right = insertRec(node.right, value);
            }
            return node;
        }

        void findSingleChildNodes(Node node, List<Integer> result) {
            if (node == null) {
                return;
            }
            if ((node.left == null && node.right != null) || (node.left != null && node.right == null)) {
                result.add(node.value);
            }
            findSingleChildNodes(node.left, result);
            findSingleChildNodes(node.right, result);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] parts = reader.readLine().split(" ");
        BST tree = new BST();
        for (String part : parts) {
            int value = Integer.parseInt(part);
            if (value == 0) break;
            tree.insert(value);
        }

        List<Integer> result = new ArrayList<>();
        tree.findSingleChildNodes(tree.root, result);
        Collections.sort(result);

        for (int num : result) {
            writer.write(num + "\n");
        }

        reader.close();
        writer.close();
    }
}