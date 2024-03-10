import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


//Refer to Leetcode Question 300 (Longest Increasing Subsequence) Optimal solution Using Binary Search for this
//sort the array in ascending order based on 1st vale, if the 1st value is same then sort in decreasing order in the second value
//then apply the binary search approach on q300
class Solution
{
    private int solve(int[][] envelopes)
    {
        Arrays.sort(envelopes, (o1, o2) -> {
            int compareRes = Integer.compare(o1[0],o2[0]);
            if(compareRes == 0) return Integer.compare(o2[1],o1[1]);
            return compareRes;
        });

        List<Integer> ans = new ArrayList<>();
        ans.add(envelopes[0][1]);

        for (int i = 1; i < envelopes.length; i++) {
            if(envelopes[i][1] > ans.getLast()) ans.add(envelopes[i][1]);
            else
            {
                //find index of just big element
                int index = Arrays.binarySearch(ans.toArray(),envelopes[i][1]);
                if(index < 0) index = -(index+1);

                ans.set(index, envelopes[i][1]);
            }
        }

        return ans.size();
    }
    public int maxEnvelopes(int[][] envelopes)
    {
        return solve(envelopes);
    }
}