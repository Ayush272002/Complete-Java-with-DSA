class Solution
{
    public boolean divisorGame(int n)
    {
        return (n&1) != 1;
    }
}
/*
if n&1 will gives 0 -> even, else odd
 */