import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println();
        Scanner x = new Scanner(System.in);
        int n;
        System.out.println("Enter the size of the array");
        n = x.nextInt();
        int[] arr= new int[n];
        System.out.println("Enter in mountain order");
        for (int i = 0; i < n; i++) {
            System.out.println("Enter "+(i+1)+" value");
            arr[i] = x.nextInt();
        }
        Solution s= new Solution();
        System.out.println("Highest value is at index "+(s.peakIndexInMountainArray(arr)+1));

        x.close();
    }
}