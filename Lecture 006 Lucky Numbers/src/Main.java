import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner x = new Scanner(System.in);
        String inp = x.nextLine();
        char[] arr = inp.toCharArray();
        int digits = arr.length;

        long ans = 0;
        ans = (1L <<digits) - 2; //gp
        for(long i = digits-1, count = 0; i>=0; i--,count++)
        {
            if(arr[(int) i] == '7') ans += (1L <<count);
        }

        System.out.println(ans+1);
        x.close();
    }
}