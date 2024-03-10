import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OptimalSolUSingBinarySearch
{
    private int solve(int[] nums)
    {
        int n = nums.length;
        if(n == 0) return 0;

        List<Integer> ans = new ArrayList<>();
        ans.add(nums[0]);

        for (int i = 1; i < n; i++) {
            if(nums[i] > ans.getLast()) ans.add(nums[i]);
            else
            {
                //find index of just big element
                int index = Arrays.binarySearch(ans.toArray(), nums[i]);
                if (index < 0) index = -(index + 1);

                ans.set(index, nums[i]);
            }
        }

        return ans.size();
    }
    public int lengthOfLIS(int[] nums)
    {
        return solve(nums);
    }
}
