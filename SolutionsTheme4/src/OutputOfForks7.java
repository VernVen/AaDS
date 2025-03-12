import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class OutputOfForks7 {

    static class TreeNode {
        int value;
        TreeNode leftChild, rightChild;

        TreeNode(int value) {
            this.value = value;
            leftChild = rightChild = null;
        }
    }

    static TreeNode insert(TreeNode root, int value) {
        if (root == null) {
            return new TreeNode(value);
        }
        if (value == root.value) return root;
        if (value < root.value) {
            root.leftChild = insert(root.leftChild, value);
        } else {
            root.rightChild = insert(root.rightChild, value);
        }
        return root;
    }

    static void findNodesWithTwoChildren(TreeNode root, ArrayList<Integer> result) {
        if (root == null) {
            return;
        }
        if (root.leftChild != null && root.rightChild != null) {
            result.add(root.value);
        }
        findNodesWithTwoChildren(root.leftChild, result);
        findNodesWithTwoChildren(root.rightChild, result);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        TreeNode root = null;
        String line;

        while ((line = reader.readLine()) != null) {
            String[] values = line.split(" ");
            for (String val : values) {
                int value = Integer.parseInt(val);
                if (value == 0) {
                    break;
                }
                root = insert(root, value);
            }
        }

        ArrayList<Integer> result = new ArrayList<>();
        findNodesWithTwoChildren(root, result);

        Collections.sort(result);
        for (int val : result) {
            writer.write(val + "\n");
        }
        writer.flush();

        reader.close();
        writer.close();
    }
}
