import java.util.Arrays;

public class Main
{
    private static void countSort(int[] arr)
    {
        if(arr == null || arr.length <= 1) return;

        int max = arr[0];
        for(int n : arr) max = Math.max(max, n);

        int[] count = new int[max+1];
        for(int n : arr) count[n]++;

        int index = 0;
        for(int i = 0; i <= max; i++)
        {
            while (count[i] > 0)
            {
                arr[index] = i;
                index++;
                count[i]--;
            }
        }
    }

    public static void main(String[] args)
    {
        int[] arr = {6,3,10,9,3,4,9,7};
        countSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
