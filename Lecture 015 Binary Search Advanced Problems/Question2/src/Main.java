import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Enter the number in the array ");
        Scanner x = new Scanner(System.in);
        int n = x.nextInt();
        System.out.println("Start inputting the values ");
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Enter the value for "+(i+1)+"position");
            arr[i]= x.nextInt();
        }
        System.out.println("Enter the number of painters");
        int m = x.nextInt();
        Solution s = new Solution();
        System.out.println("Answer is :"+s.allocate(arr,n,m));
        x.close();
    }
}