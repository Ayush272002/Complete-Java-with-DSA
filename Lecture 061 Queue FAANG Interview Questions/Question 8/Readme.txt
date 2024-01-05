Given an array of both positive and negative integers, the task is to compute sum of minimum and maximum elements of all sub-array of size k.

Examples:

Input : arr[] = {2, 5, -1, 7, -3, -1, -2}
        K = 4
Output : 18
Explanation :  Sub-arrays of size 4 are :
     {2, 5, -1, 7},   min + max = -1 + 7 = 6
     {5, -1, 7, -3},  min + max = -3 + 7 = 4
     {-1, 7, -3, -1}, min + max = -3 + 7 = 4
     {7, -3, -1, -2}, min + max = -3 + 7 = 4

     Missing sub arrays -

     {2, -1, 7, -3}
     {2, 7, -3, -1}
     {2, -3, -1, -2}
     {5, 7, -3, -1}
     {5, -3, -1, -2}
     and few more -- why these were not considered??
     Considering missing arrays result coming as 27

     Sum of all min & max = 6 + 4 + 4 + 4

                          = 18
