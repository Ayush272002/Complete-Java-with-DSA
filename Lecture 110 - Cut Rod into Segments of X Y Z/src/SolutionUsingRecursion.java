public class SolutionUsingRecursion {
    private static int solve(int n, int x, int y, int z)
    {
        //base case
        if(n == 0) return 0;
        if(n < 0) return Integer.MIN_VALUE;

        int a = solve(n-x,x,y,z) + 1;
        int b = solve(n-y,x,y,z) + 1;
        int c = solve(n-z, x, y,z) + 1;

        int ans = Math.max(a,Math.max(b,c));
        return ans;
    }
    public static int cutSegments(int n, int x, int y, int z)
    {
        // Write your code here.
        int ans = solve(n,x,y,z);
        return Math.max(ans, 0);
    }
}