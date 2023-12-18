public class BinarySearch {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int start = 0, end = n - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] == target)
                return mid;

            // Check which part of the array is sorted
            if (nums[start] <= nums[mid])
            { // Left part is sorted
                if (nums[start] <= target && target < nums[mid])
                    end = mid - 1;
                else
                    start = mid + 1;
            }
            else
            { // Right part is sorted
                if (nums[mid] < target && target <= nums[end])
                    start = mid + 1;
                else
                    end = mid - 1;
            }
        }

        return -1;
    }
}
