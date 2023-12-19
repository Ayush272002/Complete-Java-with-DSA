import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner x = new Scanner(System.in);
        System.out.println("Enter the size of the array");
        int n = x.nextInt();
        System.out.println("Now start entering the values");
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Enter the value at position :"+(i+1));
            arr[i] = x.nextInt();
        }
        SelectionSort s = new SelectionSort();
        s.sort(arr,n);
        System.out.println("Sorted array is ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i]+" ");
        }
        x.close();
    }
}
