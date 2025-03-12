

public class SecondMax2 {
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

    static int findSecondLargest(Node root) {
        Node parent = null, current = root;
        while (current.right != null) {
            parent = current;
            current = current.right;
        }
        if (current.left != null) {
            current = current.left;
            while (current.right != null) {
                current = current.right;
            }
            return current.value;
        }
        return parent.value;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        Node root = null;
        String[] parts = reader.readLine().split(" ");

        for (String part : parts) {
            int num = Integer.parseInt(part);
            if (num == 0) break;
            root = insert(root, num);
        }

        writer.write(findSecondLargest(root) + "\n");

        reader.close();
        writer.flush();
        writer.close();
    }
}
