class SolutionUsingRecursion
{
    private int solve(int n, int[] days, int[] costs, int index)
    {
        //base case
        if(index >= n) return 0;

        //1 day pass
        int option1 = costs[0] + solve(n,days,costs,index+1);

        //7 day pass
        int i;
        for (i = index; i < n && days[i] < days[index] + 7; i++);
        int option2 = costs[1] + solve(n, days, costs, i);


        //30 days pass
        for (i = index; i < n && days[i] < days[index] + 30; i++);
        int option3 = costs[2] + solve(n, days, costs, i);


        return Math.min(option1, Math.min(option2,option3));
    }
    public int mincostTickets(int[] days, int[] costs)
    {
        return solve(days.length, days, costs, 0);
    }
}