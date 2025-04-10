import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

public class PathInGraph4 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(reader.readLine());
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            String[] parts = reader.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                matrix[i][j] = Integer.parseInt(parts[j]);
            }
        }

        String[] parts = reader.readLine().split(" ");
        int start = Integer.parseInt(parts[0]) - 1;
        int end = Integer.parseInt(parts[1]) - 1;

        int[] prev = new int[n];
        Arrays.fill(prev, -1);
        boolean[] visited = new boolean[n];
        Deque<Integer> queue = new ArrayDeque<>();
        visited[start] = true;
        queue.add(start);

        while (!queue.isEmpty()) {
            int curr = queue.poll();
            for (int i = 0; i < n; i++) {
                if (matrix[curr][i] == 1 && !visited[i]) {
                    visited[i] = true;
                    prev[i] = curr;
                    queue.add(i);
                }
            }
        }

        if (!visited[end]) {
            writer.write("-1\n");
        } else {
            List<Integer> path = new ArrayList<>();
            for (int v = end; v != -1; v = prev[v]) {
                path.add(v + 1);
            }
            int len = path.size() - 1;
            writer.write(len + "\n");
            if (len > 0) {
                for (int i = path.size() - 1; i >= 0; i--) {
                    writer.write(path.get(i) + (i > 0 ? " " : "\n"));
                }
            }
        }

        reader.close();
        writer.close();
    }
}
