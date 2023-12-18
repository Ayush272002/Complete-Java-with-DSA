3Binary search is applicable on monotonic functions.

eg1: 3,5,9,13,27.......key =13
first take the mid-element i.e., 9
is 9==13 -> no
now divide the list in two parts i.e., 3,5 and 13,27
13 > 9. so we need to search in the 2nd part i.e., 13 and 27
now take the mid-element of 13 and 27, index of 13 is 3 and index of 27 is 4.
mid = (3+4)/2 = 3
so mid-element is now 13.
now compare it with key i.e., 13(key)
is 13 ==13 -> yes
return 3

eg2: 3,7,11,13,19,27......key =27
take the first mid-element i.e., 5/2 =2
is 11==27 -> no
now divide the list into two parts i.e.,3,7 and 13,19,27
27>11 -> move to the right for checking
take the mid-element of 13(index=3),19,27(index=5) i.e., (3+5)/2 =4
is 19==27 ->no
split that list into two parts i.e., 13 and 27 taking 19 as pivot
27(key)>19, so  ove to the right part
index of 27 ==5
mid = (5+5)/2 = 5 i.e., element 27
is 27==27->yes
return 5

if the element didn't exist return -1

Time complexity(Best) - O(1)
Time complexity(Average and worst) - O(log n)
