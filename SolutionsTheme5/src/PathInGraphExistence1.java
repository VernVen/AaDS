import java.io.*;

public class PathInGraphExistence1 {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;
        for (int[] edge : edges) {
            union(parent, edge[0], edge[1]);
        }
        return find(parent, source) == find(parent, destination);
    }

    private int find(int[] parent, int x) {
        if (parent[x] != x) parent[x] = find(parent, parent[x]);
        return parent[x];
    }

    private void union(int[] parent, int x, int y) {
        int px = find(parent, x);
        int py = find(parent, y);
        if (px != py) parent[px] = py;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter w = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] parts = r.readLine().split(" ");
        int n = Integer.parseInt(parts[0]);
        int m = Integer.parseInt(parts[1]);
        int[][] edges = new int[m][2];
        for (int i = 0; i < m; i++) {
            parts = r.readLine().split(" ");
            edges[i][0] = Integer.parseInt(parts[0]);
            edges[i][1] = Integer.parseInt(parts[1]);
        }
        int source = Integer.parseInt(r.readLine());
        int destination = Integer.parseInt(r.readLine());

        Solution sol = new Solution();
        boolean result = sol.validPath(n, edges, source, destination);
        w.write(result ? "true\n" : "false\n");
        w.flush();
    }
}
