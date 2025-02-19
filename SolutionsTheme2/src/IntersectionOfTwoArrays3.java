import java.util.ArrayList;
import java.util.Arrays;

public class IntersectionOfTwoArrays3 {
        public int[] intersect(int[] nums1, int[] nums2) {
            var commonElements = new ArrayList<Integer>();
            Arrays.sort(nums1);
            Arrays.sort(nums2);

            int i = 0, j = 0;

            while (i < nums1.length && j < nums2.length) {
                if (nums1[i] == nums2[j]) {
                    commonElements.add(nums1[i]);
                    i++;
                    j++;
                } else if (nums1[i] < nums2[j]) {
                    i++;
                } else {
                    j++;
                }
            }

            return commonElements.stream().mapToInt(x -> x).toArray();
        }
    }
