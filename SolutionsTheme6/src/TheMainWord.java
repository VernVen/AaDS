import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, Integer> freq = new HashMap<>();

        while (sc.hasNext()) {
            String word = sc.next();
            freq.put(word, freq.getOrDefault(word, 0) + 1);
        }

        String result = null;
        int maxCount = 0;

        for (Map.Entry<String, Integer> entry : freq.entrySet()) {
            String word = entry.getKey();
            int count = entry.getValue();

            if (count > maxCount || (count == maxCount && word.compareTo(result) < 0)) {
                maxCount = count;
                result = word;
            }
        }

        System.out.println(result);
    }
}
