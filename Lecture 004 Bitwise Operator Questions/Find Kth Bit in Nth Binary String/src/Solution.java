class Solution
{
    private int solve(int n, int k)
    {
        if(n == 1 && k == 1) return 0;
        int mid = 1 << (n-1);

        if(k < mid) return solve(n-1,k);
        else if(k == mid) return 1;
        else return 1- ( solve(n - 1, (mid << 1) - k));

    }
    public char findKthBit(int n, int k)
    {
        return (char) (solve(n,k) + '0');
    }
}