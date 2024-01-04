public class Solution {
    int tour(int[] petrol, int[] distance)
    {
        int deficit = 0;
        int balance = 0;
        int start = 0;

        for (int i = 0; i < petrol.length; i++) {
            balance = balance + petrol[i] - distance[i];
            if(balance < 0)
            {
                deficit += balance;
                start = i+1;
                balance = 0;
            }
        }
        if(deficit + balance >=0) return start;
        else return -1;
    }
}
