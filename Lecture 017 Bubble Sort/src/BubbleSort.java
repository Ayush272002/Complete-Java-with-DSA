public class BubbleSort {
    public void sort(int[] arr, int n)
    {
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n -i; j++) {
                if(arr[j]>arr[j+1])
                {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }

    public void OptimisedBubbleSort(int[] arr, int n)
    {
        for (int i = 1; i < n; i++) {
            boolean swap = false;
            for (int j = 0; j < n -i; j++) {
                if(arr[j]>arr[j+1])
                {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    swap = true;
                }
            }
            if(!swap)
                break;
        }
    }
}
