public class SolutionUsingRecursion
{
    static int solve(int[] weight, int[] value, int index, int capacity)
    {
        //base case

        if(index == 0)
        {
            if(weight[0] <= capacity) return value[0];
            else return 0;
        }

        int include = 0;
        if(weight[index] <= capacity)
            include = value[index] + solve(weight,value,index-1,capacity-weight[index]);


        //excluded so capacity remains same
        int exclude = solve(weight, value, index-1, capacity);


        int ans = Math.max(include,exclude);
        return ans;
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

        return solve(weight, value, n-1, maxWeight);
    }
}