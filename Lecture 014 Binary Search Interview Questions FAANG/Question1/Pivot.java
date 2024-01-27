public class Pivot {
     public int getpivot(int[] arr, int n)
     {
          int s=0, e = n-1, mid = s+(e-s)/2;
          while(s<e)
          {
               if(arr[mid] >= arr[0])
                    s= mid+1;
               else
                    e = mid-1;

               mid = s+(e-s)/2;
          }
          return s;
     }
}
