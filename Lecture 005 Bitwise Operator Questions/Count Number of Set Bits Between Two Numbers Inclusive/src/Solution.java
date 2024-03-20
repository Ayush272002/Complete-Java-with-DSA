import java.util.Scanner;

public class Solution
{
    private static int countSetBits(int n)
    {
        int count = 0;
        while(n > 0)
        {
            count += n&1;
            n = n>>1;
        }
        return count;
    }
    public static void main(String[] args)
    {
        Scanner x= new Scanner(System.in);
        System.out.println("Enter 1st number");
        int a = x.nextInt();
        System.out.println("Enter 2nd number");
        int b = x.nextInt();

        int count = 0;
        for (int i = a; i <= b; i++)
        {
            //check if the number is even and less than b
            if((i&1)==0 && i < b)
            {
                count += 2*countSetBits(i) + 1;
                i++;
                continue;
                /*
                if the number is even number of set bits in the next number will be 1 more than the current number
                thats why this is implemented to increase the efficiency.
                 */
            }

            count += countSetBits(i);
        }

        System.out.println("Count is : "+ count);
        x.close();
    }
}
