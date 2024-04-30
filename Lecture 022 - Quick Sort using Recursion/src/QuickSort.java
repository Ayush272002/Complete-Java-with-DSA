public class QuickSort
{
    public void quickSort(int[] arr, int s, int e)
    {
        //base case
        if(s >= e) return;

        //partition
        int p = partition(arr, s, e);

        //left sort
        quickSort(arr, s, p-1);

        //right sort
        quickSort(arr, p+1, e);
    }

    private int partition(int[] arr, int s, int e)
    {
        int pivot = arr[s];

        int count = 0;
        for(int i = s+1; i <= e; i++)
        {
            if(arr[i] <= pivot) count++;
        }

        //place pivot at right position
        int pivotIndex = s + count;

        //swap
        int temp = arr[pivotIndex];
        arr[pivotIndex] = arr[s];
        arr[s] = temp;

        //left and right part handle
        int i = s, j = e;
        while(i < pivotIndex && j > pivotIndex)
        {
            while(arr[i] <= pivot) i++;
            while(arr[j] > pivot) j--;

            if(i < pivotIndex && j > pivotIndex)
            {
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
        }

        return pivotIndex;
    }
}
