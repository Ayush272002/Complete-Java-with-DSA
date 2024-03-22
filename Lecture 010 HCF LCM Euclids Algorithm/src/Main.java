import java.util.Scanner;

public class Main
{
    private static int gcd(int a, int b)
    {
        if(a == 0) return b;
        if(b == 0) return a;

        while(a != b)
        {
            if(a>b) a -= b;
            else b -= a;
        }

        return a;
    }
    public static void main(String[] args)
    {
        System.out.println("Enter 1st number");
        Scanner x  = new Scanner(System.in);
        int a = x.nextInt();
        System.out.println("Enter 2nd number");
        int b = x.nextInt();

        int hcf = gcd(a,b);
        int lcm = (a*b)/hcf;
        System.out.println("GCD IS : "+hcf);
        System.out.println("LCM IS : "+lcm);
        x.close();
    }
}
