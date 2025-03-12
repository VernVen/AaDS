import java.io.*;

public class Bypass1 {
    static class Node {
        int value;
        Node left, right;

        Node(int value) {
            this.value = value;
        }
    }

    static Node insert(Node root, int value) {
        if (root == null) return new Node(value);
        if (value < root.value) root.left = insert(root.left, value);
        else if (value > root.value) root.right = insert(root.right, value);
        return root;
    }

    static void inOrder(Node root, BufferedWriter writer) throws IOException {
        if (root == null) return;
        inOrder(root.left, writer);
        writer.write(root.value + "\n");
        inOrder(root.right, writer);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        Node root = null;
        String line = reader.readLine();
        String[] parts = line.split(" ");

        for (String part : parts) {
            int num = Integer.parseInt(part);
            if (num == 0) break;
            root = insert(root, num);
        }

        inOrder(root, writer);

        reader.close();
        writer.flush();
        writer.close();
    }
}
