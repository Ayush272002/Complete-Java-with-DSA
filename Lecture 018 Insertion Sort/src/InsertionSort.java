public class InsertionSort {
    public void sort(int[] arr, int n)
    {
        for (int i = 0; i < n ; i++) {
            int temp = arr[i];
            int j = i-1;
            for(;j>=0;j--)
            {
                if(arr[j]>temp)
                    arr[j+1] = arr[j];
                else
                    break;
            }
            arr[j+1]=temp;
        }
    }

    public void sortWhileLoop(int[] arr, int n)
    {
        for (int i = 0; i < n; i++) {
            int j=i;
            int temp = arr[j];
            while(j>0 && temp < arr[j-1])
            {
                arr[j] = arr[j-1];
                j--;
            }
            arr[j] = temp;
        }
    }
}
