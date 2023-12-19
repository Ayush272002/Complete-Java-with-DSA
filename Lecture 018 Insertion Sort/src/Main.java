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
        InsertionSort s = new InsertionSort();
        s.sort(arr,n);

        System.out.println("Sorted array using for loop is ");
        for (int i = 0; i < n; i++)
            System.out.print(arr[i]+" ");

        System.out.println();

        s.sortWhileLoop(arr,n);
        System.out.println("Sorted array using while loop is ");
        for (int i = 0; i < n; i++)
            System.out.print(arr[i]+" ");
        x.close();
    }
}

