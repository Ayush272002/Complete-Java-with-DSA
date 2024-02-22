The first line must contain Initialize(m) where m is the order of the B+ tree
All subsequent lines may contain only the following operations:
Insert(key, value) where key is an integer and value is a floating point number
Delete(key) where key is the key of the dictionary pair you would like to delete
Search(key) where key is the key of the dictionary pair whose value you would like to find
Search(lowerBound, upperBound) where all values of dictionary pairs whose keys fall within lowerBound ≤ key ≤ upperBound will be recorded
Output for each search query will be recorded within a file titled output_file.txt.

Sample Input File
Initialize(3)
Insert(21, 0.3534)
Insert(108, 31.907)
Insert(56089, 3.26)
Insert(234, 121.56)
Insert(4325, -109.23)
Delete (108)
Search(234)
Insert(102, 39.56)
Insert(65, -3.95)
Delete (102)
Delete (21)
Insert(106, -3.91)
Insert(23, 3.55)
Search(23, 99)
Insert(32, 0.02)
Insert(220, 3.55)
Delete (234)
Search(65)



Sample Output File
121.56
3.55, -3.95
-3.95