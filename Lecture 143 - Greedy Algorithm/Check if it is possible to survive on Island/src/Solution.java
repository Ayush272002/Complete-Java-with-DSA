class Solution
{
    static int minimumDays(int S, int N, int M)
    {
        // code here
        int sunday = S/7;

        int buyingDays = S-sunday;
        int totalFood = S*M;
        int ans;

        if(totalFood % N == 0) ans = totalFood/N;
        else ans = totalFood/N + 1;

        if(ans <= buyingDays) return ans;
        else return -1;
    }
}