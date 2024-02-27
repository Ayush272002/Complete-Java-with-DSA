public class Solution {
    public static long OptimisedSol(int n)
    {
        // Write your code here.

        //base case
        long prev2  = 0;
        long prev1  = 1;

        for (int i = 3; i <= n; i++)
        {
            long first = prev1 %1000000007;
            long second = prev2 %1000000007;

            long sum = (first + second) %1000000007;

            long ans = ((i-1) * sum) %1000000007;

            prev2 = prev1;
            prev1 = ans;
        }

        return prev1;
    }
}