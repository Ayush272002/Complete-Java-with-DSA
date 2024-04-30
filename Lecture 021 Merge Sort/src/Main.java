import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner x = new Scanner(System.in);
        System.out.println("Enter the size of the array");
        int n = x.nextInt();
        System.out.println("Start entering the numbers");
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.println("enter the number at position "+(i+1));
            arr[i] = x.nextInt();
        }
        System.out.println("======================");
        MergeSort sort = new MergeSort();
        sort.sort(arr,0,n-1);

        for (int i = 0; i < n; i++) {
            System.out.println(arr[i] + " ");
        }
        x.close();
    }
}
