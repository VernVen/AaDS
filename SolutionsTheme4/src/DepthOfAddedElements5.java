import java.io.*;

public class DepthOfAddedElements5 {

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

        public boolean insert(int value) {
            return insertRec(root, value, 1);
        }

        private boolean insertRec(Node root, int value, int depth) {
            if (root == null) {
                this.root = new Node(value);
                return true;
            }
            if (value < root.value) {
                if (root.left == null) {
                    root.left = new Node(value);
                    return true;
                } else {
                    return insertRec(root.left, value, depth + 1);
                }
            } else if (value > root.value) {
                if (root.right == null) {
                    root.right = new Node(value);
                    return true;
                } else {
                    return insertRec(root.right, value, depth + 1);
                }
            }
            return false;
        }

        public int findDepth(int value) {
            return findDepthRec(root, value, 1);
        }

        private int findDepthRec(Node root, int value, int depth) {
            if (root == null) {
                return -1;
            }
            if (value == root.value) {
                return depth;
            } else if (value < root.value) {
                return findDepthRec(root.left, value, depth + 1);
            } else {
                return findDepthRec(root.right, value, depth + 1);
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
            if (tree.insert(num)) {
                writer.write(String.valueOf(tree.findDepth(num)) + " ");
            }
        }

        writer.newLine();
        writer.close();
        reader.close();
    }
}
