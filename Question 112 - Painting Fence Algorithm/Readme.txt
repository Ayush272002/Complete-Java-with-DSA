Ninja has given a fence, and he gave a task to paint this fence. The fence has 'N' posts, and Ninja has 'K' colors. Ninja wants to paint the fence so that
not more than two adjacent posts have the same color.
Ninja wonders how many ways are there to do the above task, so he asked for your help.
Your task is to find the number of ways Ninja can paint the fence. Print the answer modulo 10^9 + 7.

Example:
Input: 'N' = 3, 'K' = 2
Output: 6

Say we have the colors with the numbers 1 and 0. We can paint the fence with 3 posts with the following different combinations.

110
001
101
100
010
011
Detailed explanation ( Input/output format, Notes, Images )
Constraints :
1 <= ‘T’ <= 10
1 <= 'N' <= 10^5
1 <= 'K' <= 10^5
Time Limit: 1 sec
Sample Input 1 :
2
1 1
3 2
Sample Output 1 :
1
6
Explanation Of Sample Input 1 :
For the first test case, there is only one way to paint the fence.

For the second test case, We can paint the fence with 3 posts with the following different combinations.

110
001
101
100
010
011
Sample Input 2 :
2
2 4
4 2
Sample Output 2 :
16
10