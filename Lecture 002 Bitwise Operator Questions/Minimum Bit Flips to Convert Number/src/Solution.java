class Solution
{
    int countSetBits(int n)
    {
        int count = 0;
        while(n > 0)
        {
            count += n&1;
            n = n>>1;
        }

        return count;
    }
    public int minBitFlips(int start, int goal)
    {
        int n = start^goal;
        return countSetBits(n);
    }
}