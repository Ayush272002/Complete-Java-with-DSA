import java.util.Arrays;

public class Main
{
    private static void pigeonhole_sort(int[] arr)
    {
        int n = arr.length;

        // Find the minimum and maximum values in the array
        int min = Arrays.stream(arr).min().getAsInt();
        int max = Arrays.stream(arr).max().getAsInt();


        // Create a pigeonhole array of size (max - min + 1)
        int[] pigeonhole = new int[max - min + 1];

        // Increment the count of each element in the pigeonhole array
        for (int i = 0; i < n; i++) {
            pigeonhole[arr[i] - min]++;
        }

        // Fill the original array with sorted elements
        int index = 0;
        for (int i = 0; i < pigeonhole.length; i++) {
            while (pigeonhole[i] > 0) {
                arr[index++] = i + min;
                pigeonhole[i]--;
            }
        }
    }

    public static void main(String[] args)
    {
        int[] arr =  {89,90,45,34,2,1,87,20,0,4,6,7,7};
        pigeonhole_sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
