import java.util.List;

public class Heap
{
    private int[] arr;
    private int size;

    Heap()
    {
        arr = new int[100];
        arr[0] = -1; //not accessing the 0th position
        size = 0;
    }

    public void insert(int val)
    {
        size = size + 1;
        int index = size;
        arr[index] = val;


        while(index > 1)
        {
            int parent = index/2;


            if(arr[parent] < arr[index])
            {
                //swap the values
                int temp = arr[parent];
                arr[parent] = arr[index];
                arr[index] = temp;
                index = parent;
            }
            else
            {
                //reached at correct spot
                return;
            }
        }
    }

    public void deleteFromHeap()
    {
        if(size == 0)
        {
            System.out.println("Nothing to delete");
            return;
        }

        arr[1] = arr[size]; //step 1 : put last element into 1st index
        size--; //step 2 : remove last element ,so that its inaccessible now

        //step 3 : take root node to its correct position
        int i =1;
        while(i < size)
        {
            int leftIndex = 2*i;
            int rightIndex = (2*i) + 1;

            if(leftIndex < size && arr[i] < arr[leftIndex])
            {
                //swap arr[i] and arr[leftIndex]
                int temp = arr[i];
                arr[i] = arr[leftIndex];
                arr[leftIndex] = temp;
                i = leftIndex;
            }
            else if(rightIndex < size && arr[i] < arr[rightIndex])
            {
                //swap arr[i] and arr[rightIndex]
                int temp = arr[i];
                arr[i] = arr[rightIndex];
                arr[rightIndex] = temp;
                i = rightIndex;
            }
            else
            {
                //everything is placed correctly
                return;
            }
        }
    }

    void heapify(int[] arr, int n , int i) //1 based indexing
    {
        int largest = i;
        int left = 2*i; // for 0 based indexing 2i + 1
        int right = 2*i + 1; // for 0 based indexing 2i + 2

        if(left <= n && arr[largest] < arr[left]) // <= cause 1 based indexing if it was 0 based then <
            largest = left;

        if(right <= n && arr[largest] < arr[right]) // <= cause 1 based indexing if it was 0 based then <
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

    void minHeapify(List<Integer> arr, int n, int i)
    {
        int smallest = i;
        int left = 2*i + 1;
        int right = 2*i + 2;

        if(left < n && arr.get(smallest) > arr.get(left))
            smallest = left;

        if(right < n && arr.get(smallest) > arr.get(right))
            smallest = right;

        if(smallest != i)
        {
            //swap arr[smallest] and arr[i]
            int temp = arr.get(smallest);
            arr.add(smallest,arr.get(i));
            arr.add(i,temp);

            //check further up
            minHeapify(arr, n, smallest);
        }
    }

    List<Integer> buildMinHeap(List<Integer> arr)
    {
        int n =arr.size();
        for (int i = (n/2)-1; i >= 0 ; i--) {
            minHeapify(arr, n, i);
        }
        return arr;
    }

    public void print()
    {
        for (int i = 1; i <= size ; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public void heapSort(int[] arr, int n)
    {
        int size = n;

        while(size > 1)
        {
            //step 1 : swap
            int temp = arr[size];
            arr[size] = arr[1];
            arr[1] = temp;


            size--;

            //step 2
            heapify(arr,size,1);
        }
    }
}
