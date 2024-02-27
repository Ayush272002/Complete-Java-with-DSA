public class SolutionRecursion
{
    private static int add(int a, int b)
    {
        return((a%1000000007 + b%1000000007)%1000000007);
    }

    private static int mul(int a, int b)
    {
        return(((a%1000000007) * (b%1000000007))%1000000007);
    }

    private static int solve(int n, int k)
    {
        //base case
        if(n == 1) return k;
        if(n == 2) return add(k,mul(k,k-1));

        int ans = add(mul(solve(n-2,k),k-1), mul(solve(n-1, k), k-1));
        return ans;
    }
    public static int numberOfWays(int n, int k) {
        // Write your code here.
        return solve(n,k);
    }
}