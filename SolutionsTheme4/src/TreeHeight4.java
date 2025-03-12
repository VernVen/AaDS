import java.io.*;

public class TreeHeight4 {

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

        public int height() {
            return heightRec(root);
        }

        private int heightRec(Node root) {
            if (root == null) {
                return 0;
            }
            int leftHeight = heightRec(root.left);
            int rightHeight = heightRec(root.right);
            return Math.max(leftHeight, rightHeight) + 1;
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

        writer.write(String.valueOf(tree.height()));
        writer.newLine();
        writer.close();
        reader.close();
    }
}
