import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class CorrectParenthesesSequence5 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        String sequence = reader.readLine();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < sequence.length(); i++) {
            char current = sequence.charAt(i);

            if (current == '(' || current == '[' || current == '{') {
                stack.push(current);
            } else {
                if (stack.isEmpty()) {
                    writer.write("no");
                    writer.close();
                    return;
                }
                char top = stack.pop();
                if ((current == ')' && top != '(') ||
                        (current == ']' && top != '[') ||
                        (current == '}' && top != '{')) {
                    writer.write("no");
                    writer.close();
                    return;
                }
            }
        }
        if (stack.isEmpty()) {
            writer.write("yes");
        } else {
            writer.write("no");
        }
        reader.close();
        writer.close();
    }
}
