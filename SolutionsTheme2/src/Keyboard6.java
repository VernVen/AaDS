import java.io.*;
import java.util.*;

public class Keyboard6 {
        public static void main(String[] args) throws IOException {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

            int n = Integer.parseInt(reader.readLine());
            int[] durability = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int k = Integer.parseInt(reader.readLine());
            int[] presses = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            int[] counts = new int[n];

            for (int key : presses) {
                counts[key - 1]++;
            }

            for (int i = 0; i < n; i++) {
                writer.write((counts[i] > durability[i] ? "YES" : "NO") + "\n");
            }

            writer.flush();
            reader.close();
            writer.close();
        }
    }
