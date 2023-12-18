import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println();
        Scanner x = new Scanner(System.in);
        int n, key;
        System.out.println("Enter the size of the array");
        n = x.nextInt();
        int[] arr= new int[n];
        System.out.println("Enter in ascending order");
        for (int i = 0; i < n; i++) {
            System.out.println("Enter "+(i+1)+" value");
            arr[i] = x.nextInt();
        }
        System.out.println("Enter the key to be searched");
        key = x.nextInt();

        BinarySearch bs = new BinarySearch();
        int start = bs.firstOcc(arr,n,key);
        int end = bs.lastOcc(arr,n,key);
        if(start !=-1 && end !=-1)
            System.out.println("Number of occurrences are "+(end-start+1));
        else
            System.out.println("Key doesnt exist");

        x.close();
    }
}