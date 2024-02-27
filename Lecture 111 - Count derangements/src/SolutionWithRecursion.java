public class SolutionWithRecursion {
    public static long countDerangements(int n)
    {
        // Write your code here.

        //base case
        if(n==1) return 0;
        if(n==2) return 1;

        long ans = (n-1) * (countDerangements(n-1) + countDerangements(n-2));

        return ans % 1000000007;
    }
}