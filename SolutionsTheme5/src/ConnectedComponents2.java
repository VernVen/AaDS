import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class ConnectedComponents2 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] firstLine = reader.readLine().split(" ");
        int n = Integer.parseInt(firstLine[0]);
        int m = Integer.parseInt(firstLine[1]);

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) graph.add(new ArrayList<>());

        for (int i = 0; i < m; i++) {
            String[] edge = reader.readLine().split(" ");
            int u = Integer.parseInt(edge[0]);
            int v = Integer.parseInt(edge[1]);
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        boolean[] visited = new boolean[n + 1];
        List<List<Integer>> components = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                List<Integer> component = new ArrayList<>();
                dfs(i, graph, visited, component);
                components.add(component);
            }
        }

        writer.write(String.valueOf(components.size()));
        writer.newLine();
        for (List<Integer> comp : components) {
            writer.write(String.valueOf(comp.size()));
            writer.newLine();
            for (int v : comp) {
                writer.write(v + " ");
            }
            writer.newLine();
        }

        reader.close();
        writer.close();
    }

    private static void dfs(int node, List<List<Integer>> graph, boolean[] visited, List<Integer> component) {
        Stack<Integer> stack = new Stack<>();
        stack.push(node);
        visited[node] = true;
        while (!stack.isEmpty()) {
            int current = stack.pop();
            component.add(current);
            for (int neighbor : graph.get(current)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    stack.push(neighbor);
                }
            }
        }
    }
}

