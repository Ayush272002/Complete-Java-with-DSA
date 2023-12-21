import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner x = new Scanner(System.in);


        System.out.println("Enter the numbers in 1st array ");
        int n = x.nextInt();
        System.out.println("Start entering ");
        int[] arr1 = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Enter the value at position "+(i+1));
            arr1[i] = x.nextInt();
        }

        System.out.println("Enter the numbers in 1st array ");
        int m = x.nextInt();
        System.out.println("Start entering ");
        int[] arr2 = new int[m];
        for (int i = 0; i < m; i++) {
            System.out.println("Enter the value at position "+(i+1));
            arr2[i] = x.nextInt();
        }

        ArrayList<Integer> sum;
        Solution s= new Solution();
        sum = s.findArraySum(arr1,n,arr2,m);

        for (int i = 0; i < sum.size(); i++) {
            System.out.print(sum.get(i)+" ");
        }

        x.close();
    }
}
