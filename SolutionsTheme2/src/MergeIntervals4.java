import java.util.Arrays;
import java.util.LinkedList;

public class MergeIntervals4 {
        public int[][] merge(int[][] intervals) {
            Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
            var merged = new LinkedList<int[]>();

            for (var interval : intervals) {
                if (merged.isEmpty() || merged.getLast()[1] < interval[0]) {
                    merged.add(interval);
                } else {
                    merged.getLast()[1] = Math.max(merged.getLast()[1], interval[1]);
                }
            }

            return merged.toArray(new int[merged.size()][]);
        }
    }

