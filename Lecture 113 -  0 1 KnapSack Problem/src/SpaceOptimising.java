import java.util.Arrays;

public class SpaceOptimising
{
    static int solve(int[] weight, int[] value, int n, int capacity)
    {
        //step 1 : dp array
        int[] prev = new int[capacity+1];
        Arrays.fill(prev,0);

        int[] curr = new int[capacity+1];
        Arrays.fill(curr,0);

        //step 2 : analyse base case
        for (int w = weight[0]; w <= capacity ; w++) {
            if(weight[0] <= capacity) prev[w] = value[0];
            else prev[w] = 0;
        }

        for(int index = 1; index < n; index++)
        {
            for(int w = 0; w<= capacity; w++)
            {
                int include = 0;
                if(weight[index] <= w)
                    include = value[index] + prev[w-weight[index]];


                //excluded so capacity remains same
                int exclude = prev[w];

                curr[w] = Math.max(include,exclude);
            }

            // Copy elements of curr to prev
            System.arraycopy(curr, 0, prev, 0, curr.length);
        }

        return prev[capacity];
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