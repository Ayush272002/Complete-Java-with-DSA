Given two binary max heaps as arrays, merge the given heaps to form a new max heap.


Example 1:
Input  :
n = 4 m = 3
a[] = {10, 5, 6, 2},
b[] = {12, 7, 9}
Output :
{12, 10, 9, 2, 5, 7, 6}


Your Task:
You don't need to read input or print anything. Your task is to complete the function mergeHeaps() which takes the array a[], b[], its size n and m, as inputs and return
the merged max heap. Since there can be multiple solutions, therefore, to check for the correctness of your solution, your answer will be checked by the driver code and
will return 1 if it is correct, else it returns 0.

Expected Time Complexity: O(n.Logn)
Expected Auxiliary Space: O(n + m)



Constraints:
1 <= n, m <= 105
1 <= a[i], b[i] <= 2*105