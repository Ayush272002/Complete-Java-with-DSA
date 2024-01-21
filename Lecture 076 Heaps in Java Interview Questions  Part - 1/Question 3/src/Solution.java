class Solution{
    void heapify(int[] arr, int n , int i) //1 based indexing
    {
        int largest = i;
        int left = 2*i + 1;
        int right = 2*i + 2;

        if(left < n && arr[largest] < arr[left]) // <= cause 1 based indexing if it was 0 based then <
            largest = left;

        if(right < n && arr[largest] < arr[right])
            largest = right;

        if(largest != i)
        {
            //swap arr[largest] and arr[i]
            int temp = arr[largest];
            arr[largest] = arr[i];
            arr[i] = temp;

            //check further up
            heapify(arr, n, largest);
        }
    }
    public int[] mergeHeaps(int[] a, int[] b, int n, int m) {
        // your code here
        //step 1 : merge both arrays into one
        int[] ans = new int[a.length+b.length];

        System.arraycopy(a, 0, ans, 0, a.length);
        System.arraycopy(b, 0, ans, a.length, b.length);

        //step 2 : build heap using the merge array

        int size =ans.length;
        for (int i = size/2 - 1; i >= 0; i--) {
            heapify(ans, size, i);
        }
        return ans;
    }
}