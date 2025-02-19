public class SearchInsertPosition1 {
        public int searchInsert(int[] nums, int target) {
            int left = -1, right = nums.length;
            while (left + 1 < right) {
                int mid = (left + right) >>> 1;
                if (nums[mid] < target) {
                    left = mid;
                } else {
                    right = mid;
                }
            }
            return right;
        }
    }
