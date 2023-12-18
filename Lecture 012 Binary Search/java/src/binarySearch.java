public class binarySearch {
    public int search(int arr[], int size, int key)
    {
        int start =0;
        int end =size-1;
//  int mid = (start+end)/2;  correct if they are small but if they exceed the range then it would throw and error
        int mid = start + ((end-start)/2);
        while(start<=end)
        {
            if(arr[mid]==key)
                return mid;

            if(key>arr[mid]) //moving to right part
                start = mid+1;
            else
                end = mid-1;

            mid=start + ((end-start)/2);
        }
        return -1;
    }
}
