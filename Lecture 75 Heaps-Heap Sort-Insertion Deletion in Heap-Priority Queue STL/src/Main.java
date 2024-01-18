public class Main {
    public static void main(String[] args) {
        Heap h = new Heap();
        h.insert(50);
        h.insert(55);
        h.insert(53);
        h.insert(52);
        h.insert(54);
        h.print();

        h.deleteFromHeap();
        h.print();
        
        
        int[] arr = {-1, 54, 53, 55, 52 , 50};
        int n = 5; //-1 is not considered

        for (int i = n/2; i > 0; i--) { //leaf nodes are forming correct heaps no need to check them
            h.heapify(arr, n, i);
        }

        System.out.println("Printing the array");

        for (int i = 1; i <= n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
