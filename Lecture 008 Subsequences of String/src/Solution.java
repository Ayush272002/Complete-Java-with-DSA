import java.util.Scanner;

public class Solution
{
    public static void main(String[] args)
    {
        Scanner x = new Scanner(System.in);
        System.out.println("Enter the string");
        String s = x.nextLine();
        int n = s.length();
        int numberOfSubsequences = (1<<n)-1;

        System.out.println("{}");
        for (int i = 1; i <= numberOfSubsequences; i++)
        {
            int temp = i, j =0;
            while(temp > 0)
            {
                if((temp & 1) == 1) System.out.print(s.charAt(j));
                j++;
                temp = temp >> 1;
            }
            System.out.println();
        }
    }
}
