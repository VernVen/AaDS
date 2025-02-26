import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class TrainSortingLite7 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(reader.readLine());
        String[] input = reader.readLine().split(" ");
        Stack<Integer> stack = new Stack<>();
        int expected = 1;

        for (String s : input) {
            int car = Integer.parseInt(s);
            stack.push(car);

            while (!stack.isEmpty() && stack.peek() == expected) {
                stack.pop();
                expected++;
            }
        }

        if (stack.isEmpty()) {
            writer.write("YES\n");
        } else {
            writer.write("NO\n");
        }
        reader.close();
        writer.close();
    }
}
