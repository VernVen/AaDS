import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class CycleSearch5 {
    static int n;
    static int[][] graph;
    static boolean[] visited;
    static int[] parent;
    static int cycleStart = -1, cycleEnd = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(reader.readLine());
        graph = new int[n][n];
        visited = new boolean[n];
        parent = new int[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(reader.readLine());
            for (int j = 0; j < n; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        boolean found = false;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                if (dfs(i, -1)) {
                    found = true;
                    break;
                }
            }
        }

        if (!found) {
            writer.write("NO\n");
        } else {
            writer.write("YES\n");
            java.util.List<Integer> path = new java.util.ArrayList<>();
            path.add(cycleStart);
            for (int v = cycleEnd; v != cycleStart; v = parent[v]) {
                path.add(v);
            }
            path.add(cycleStart);
            writer.write(path.size() - 1 + "\n");
            for (int i = path.size() - 2; i >= 0; i--) {
                writer.write((path.get(i) + 1) + " ");
            }
            writer.newLine();
        }

        writer.flush();
        reader.close();
        writer.close();
    }

    static boolean dfs(int v, int p) {
        visited[v] = true;
        for (int u = 0; u < n; u++) {
            if (graph[v][u] == 1) {
                if (u == p) continue;
                if (visited[u]) {
                    cycleStart = u;
                    cycleEnd = v;
                    return true;
                } else {
                    parent[u] = v;
                    if (dfs(u, v)) return true;
                }
            }
        }
        return false;
    }
}
