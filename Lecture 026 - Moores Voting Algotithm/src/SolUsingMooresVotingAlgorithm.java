public class SolUsingMooresVotingAlgorithm
{
    public int majorityElement(int[] nums)
    {
        int element = nums[0];
        int count = 0;

        for(int num : nums)
        {
            if(count == 0) element = num;
            if(num == element) count++;
            else count--;
        }

        return element;
    }
}
