import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("enter the max length of the array");
        Scanner x= new Scanner(System.in);
        int n = x.nextInt();
        System.out.println("Start entering the values");
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Enter the "+(i+1)+" value");
            arr[i] = x.nextInt();
        }
        System.out.println("Enter the value of K");
        int k = x.nextInt();
        Solution s= new Solution();
        System.out.println("The answer is "+s.aggressiveCows(arr,k));
        x.close();
    }
}
