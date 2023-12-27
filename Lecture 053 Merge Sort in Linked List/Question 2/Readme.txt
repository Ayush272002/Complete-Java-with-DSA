Given a Linked List of size N, where every node represents a sub-linked-list and contains two pointers:
(i) a next pointer to the next node,
(ii) a bottom pointer to a linked list where this node is head.
Each of the sub-linked-list is in sorted order.
Flatten the Link List such that all the nodes appear in a single level while maintaining the sorted order.
Note: The flattened list will be printed using the bottom pointer instead of next pointer.

Note: All linked lists are sorted and the resultant linked list should also be sorted

Examples:

Input:         5 -> 10 -> 19 -> 28
               |     |     |     |
               V     V     V     V
               7     20    22    35
               |           |     |
               V           V     V
               8           50    40
               |                 |
               V                 V
               30                45


Output: 5->7->8->10->19->20->22->28->30->35->40->45->50

Input:    3 -> 10 -> 7 -> 14
          |     |    |     |
          V     V    V     V
          9     47   15    22
          |          |
          V          V
          17        30

Output: 3->7->9->10->14->15->17->22->30->47