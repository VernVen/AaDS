import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;

public class GoblinsAndShamans8 {
    public static void main(String[] args) throws IOException {
        var reader = new BufferedReader(new InputStreamReader(System.in));
        var writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(reader.readLine());
        ArrayDeque<Integer> frontQueue = new ArrayDeque<>();
        ArrayDeque<Integer> backQueue = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            String line = reader.readLine().trim();
            if (line.startsWith("+")) {
                backQueue.addLast(Integer.parseInt(line.substring(2)));
            } else if (line.startsWith("*")) {
                int num = Integer.parseInt(line.substring(2));
                if (frontQueue.size() > backQueue.size()) {
                    backQueue.addFirst(num);
                } else {
                    frontQueue.addLast(num);
                }
            } else if (line.equals("-")) {
                writer.write(frontQueue.pollFirst() + "\n");
            }

            if (frontQueue.size() < backQueue.size()) {
                frontQueue.addLast(backQueue.pollFirst());
            }
        }
        reader.close();
        writer.close();
    }
}
