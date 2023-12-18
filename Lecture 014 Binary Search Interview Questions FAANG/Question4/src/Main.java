import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Enter a number whose square root needs to calculated");
        Scanner x = new Scanner(System.in);
        int n = x.nextInt();
        System.out.println("Enter the precision ");
        int precision = x.nextInt();
        Solution s= new Solution();
        System.out.println("Square root is "+s.morePrecision(n,precision,s.intSqrt(n)));
    }
}
