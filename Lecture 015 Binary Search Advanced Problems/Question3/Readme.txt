You are given an array 'arr' consisting of 'n' integers which denote the position of a stall.
You are also given an integer 'k' which denotes the number of aggressive cows.
You are given the task of assigning stalls to 'k' cows such that the minimum distance between
any two of them is the maximum possible.
Print the maximum possible minimum distance.

Example:
Input: 'n' = 3, 'k' = 2 and 'arr' = {1, 2, 3}
Output: 2

Explanation:
The maximum possible minimum distance will be 2 when 2 cows are placed at positions (1, 3).
Here distance between cows is 2.

Detailed explanation (Input/output format)

Input format:

The first line contains two integers 'n' and 'k' denoting the number of elements in the array
and the number of aggressive cows.
The second line contains 'n' single space-separated integers denoting the position of the stalls.

Output format:
Return the largest possible minimum distance between cows.