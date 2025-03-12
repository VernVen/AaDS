import java.io.*;

public class LeafOutput6 {

    static class Node {
        int value;
        Node left, right;

        Node(int value) {
            this.value = value;
            this.left = this.right = null;
        }
    }

    static class BinarySearchTree {
        private Node root;

        public void insert(int value) {
            root = insertRec(root, value);
        }

        private Node insertRec(Node root, int value) {
            if (root == null) {
                root = new Node(value);
                return root;
            }
            if (value < root.value) {
                root.left = insertRec(root.left, value);
            } else if (value > root.value) {
                root.right = insertRec(root.right, value);
            }
            return root;
        }

        public void printLeaves() {
            printLeavesRec(root);
        }

        private void printLeavesRec(Node root) {
            if (root != null) {
                if (root.left == null && root.right == null) {
                    System.out.println(root.value);
                }
                printLeavesRec(root.left);
                printLeavesRec(root.right);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        BinarySearchTree tree = new BinarySearchTree();
        String[] inputs = reader.readLine().split(" ");

        for (String input : inputs) {
            int num = Integer.parseInt(input);
            if (num == 0) break;
            tree.insert(num);
        }

        tree.printLeaves();

        writer.close();
        reader.close();
    }
}
