import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class MaxProductOfThree5 {
        public static void main(String[] args) throws IOException {
            var reader = new BufferedReader(new InputStreamReader(System.in));
            var writer = new BufferedWriter(new OutputStreamWriter(System.out));

            var numbers = Arrays.stream(reader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            Arrays.sort(numbers);
            int n = numbers.length;

            long maxProduct1 = (long) numbers[n - 1] * numbers[n - 2] * numbers[n - 3];
            long maxProduct2 = (long) numbers[0] * numbers[1] * numbers[n - 1];

            if (maxProduct1 > maxProduct2) {
                writer.write(numbers[n - 1] + " " + numbers[n - 2] + " " + numbers[n - 3]);
            } else {
                writer.write(numbers[0] + " " + numbers[1] + " " + numbers[n - 1]);
            }

            reader.close();
            writer.close();
        }
    }
