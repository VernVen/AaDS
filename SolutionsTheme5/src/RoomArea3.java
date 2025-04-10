import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class RoomArea3 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(reader.readLine());
        char[][] grid = new char[n][n];
        for (int i = 0; i < n; i++) {
            grid[i] = reader.readLine().toCharArray();
        }

        String[] pos = reader.readLine().split(" ");
        int startRow = Integer.parseInt(pos[0]) - 1;
        int startCol = Integer.parseInt(pos[1]) - 1;

        boolean[][] visited = new boolean[n][n];
        int result = dfs(grid, visited, startRow, startCol, n);

        writer.write(String.valueOf(result));
        writer.newLine();

        reader.close();
        writer.close();
    }

    private static int dfs(char[][] grid, boolean[][] visited, int row, int col, int n) {
        if (row < 0 || row >= n || col < 0 || col >= n || grid[row][col] == '*' || visited[row][col]) {
            return 0;
        }
        visited[row][col] = true;
        int count = 1;
        count += dfs(grid, visited, row + 1, col, n);
        count += dfs(grid, visited, row - 1, col, n);
        count += dfs(grid, visited, row, col + 1, n);
        count += dfs(grid, visited, row, col - 1, n);
        return count;
    }
}

