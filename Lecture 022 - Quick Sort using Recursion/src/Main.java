public class Main
{
    public static void main(String[] args)
    {
        int[] arr = {2,4,1,6,9};
        int n = 5;

        QuickSort q = new QuickSort();
        q.quickSort(arr, 0, 4);
        for (int i = 0; i < n; i++) System.out.print(arr[i] + " ");
    }
}
