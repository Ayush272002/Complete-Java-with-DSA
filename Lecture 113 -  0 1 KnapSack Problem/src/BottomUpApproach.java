public class BottomUpApproach
{
    static int solve(int[] weight, int[] value, int n, int capacity)
    {
        //step 1 : dp array
        int[][] dp = new int[n][capacity+1];

        //step 2 : analyse base case
        for (int w = weight[0]; w <= capacity ; w++) {
            if(weight[0] <= capacity) dp[0][w] = value[0];
            else dp[0][w] = 0;
        }

        for(int index = 1; index < n; index++)
        {
            for(int w = 0; w<= capacity; w++)
            {
                int include = 0;
                if(weight[index] <= w)
                    include = value[index] + dp[index-1][w-weight[index]];


                //excluded so capacity remains same
                int exclude = dp[index-1][w];

                dp[index][w] = Math.max(include,exclude);
            }
        }

        return dp[n-1][capacity];
    }
    static int knapsack(int[] weight, int[] value, int n, int maxWeight)
    {

        /* Your class should be named Solution
         * Don't write main().
         * Don't read input, it is passed as function argument.
         * Change in the given tree itself.
         * No need to return or print the output.
         * Taking input and printing output is handled automatically.
         */

        return solve(weight, value, n, maxWeight);
    }
}