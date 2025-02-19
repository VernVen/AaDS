import java.io.*;
import java.util.*;

public class MedianMerge7 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] firstLine = reader.readLine().split(" ");
        int N = Integer.parseInt(firstLine[0]);
        int L = Integer.parseInt(firstLine[1]);

        int[][] sequences = new int[N][L];

        for (int i = 0; i < N; i++) {
            sequences[i] = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                int[] merged = new int[2 * L];
                int idx1 = 0, idx2 = 0, idxMerged = 0;

                while (idx1 < L && idx2 < L) {
                    if (sequences[i][idx1] <= sequences[j][idx2]) {
                        merged[idxMerged++] = sequences[i][idx1++];
                    } else {
                        merged[idxMerged++] = sequences[j][idx2++];
                    }
                }

                while (idx1 < L) {
                    merged[idxMerged++] = sequences[i][idx1++];
                }

                while (idx2 < L) {
                    merged[idxMerged++] = sequences[j][idx2++];
                }

                writer.write(merged[L - 1] + "\n");
            }
        }

        writer.flush();
        reader.close();
        writer.close();
    }
}
