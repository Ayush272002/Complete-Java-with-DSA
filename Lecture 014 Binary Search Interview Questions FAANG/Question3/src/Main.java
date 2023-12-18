import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Enter a number whose square root needs to calculated");
        Scanner x = new Scanner(System.in);
        int n = x.nextInt();
        Solution s= new Solution();
        System.out.println("Ans is : "+s.mySqrt(n));
    }
}
