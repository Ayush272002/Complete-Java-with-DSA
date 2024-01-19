A Heap is complete binary tree that comes with a heap order property.
A complete binary tree is which in every level is completely filled except the last level and nodes are always added from the left
There are two types of heap order property
1. Max heap = a complete binary tree where every node has a value greater than or equal to its children
2. Min heap = a complete Binary Tree where the root node has the minimum key in the tree

Representing Heap Using an array (1 based indexing in the array)
Node at position -> i th index
left child -> 2*i th index
right child -> 2*i + 1 th index
parent of a node -> i/2 th index
All the leaf nodes are present in the index (n/2 + 1) to n

if its 0 based indexing then
left child -> 2i + 1 th index
right child -> 2*i + 2

Insertion for a max heap
step 1 : insert at end
step 2 : take it to its correct position repeatedly //O(log n)
Time complexity - O(log n)

Deletion in a max heap - we mean deleting the root node
step 1 : put the last node in the root
step 2 : remove last node
step 3 : propagate root node to its correct position //O(log n)
Time complexity - O(log n)

putting a node to its correct position is the work of Heapify function.
Time complexity of heapify - O(log n)
Time complexity of building an heap - O(n)

Time complexity for heap sort - O(n log n)