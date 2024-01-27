Problem statement
You are given a list/array of strings which denotes the contacts that exist in your phone directory. The search query on a string ‘str’ which is a query string displays all the contacts which are present in the given directory with the prefix as ‘str’. One special property of the search function is that when a user searches for a contact from the contact list then suggestions (contacts with prefix as the string entered so for) are shown after the user enters each character.

Note :
If no suggestions are found, return an empty 2D array.
For Example :

In the above example everytime we enter a character, a few suggestions display the strings which contain the entered string as prefixes.
Detailed explanation ( Input/output format, Notes, Images )
Constraints :
1 <= T <= 50
1 <= N <= 100
1 <= len <= 10
ARR[i] contains lowercase English alphabets.

All the given strings contain lowercase English alphabets.

Time Limit: 1 sec.
Sample Input 1 :
2
5
cod coding codding code coly
coding
2
ninjas coding
ninja
Sample Output 1 :
cod coding codding code coly
cod coding codding code coly
cod coding codding code coly
coding
coding
coding
ninjas
ninjas
ninjas
ninjas
ninjas
Explanation to Sample Input 1 :
In the first test case,
The suggestions for “c” is {“cod”, “coding”, “codding”, “code”, “coly”}.
The suggestions for “co” is {“cod”, “coding”, “codding”, “code”, “coly”}.
The suggestions for “cod” is {“cod”, “coding”, “codding”, “code”, “coly”}.
The suggestion for “codi” is {“coding”}.
The suggestion for “codin” is {“coding”}.
The suggestion for “coding” is {“coding”}.

In the second test case,
The suggestion for “n” is {“ninjas”}.
The suggestion for “ni” is {“ninjas”}.
The suggestion for “nin” is {“ninjas”}.
The suggestion for “ninj” is {“ninjas”}.
The suggestion for “ninja” is {“ninjas”}.
Sample Input 2 :
3
2
coding ninjas
cell
2
ab abc
a
2
ab abc
b
Sample Output 2 :
coding
ab abc
No suggestions found
Explanation to Sample Input 2 :
In the first test case,
The suggestion for “c” is {“coding”}.
For the rest of the letters, there are no suggestions.

In the second test case,
The suggestion for “a” is {“ab”, “abc”}.

In the third test case, no suggestions are found.
Java (17)
12345678910

import java.util.ArrayList;

public class Solution
{
    public static ArrayList<ArrayList<String>> phoneDirectory(ArrayList<String> contactList, String queryStr)
    {
        //    Write your code here.
    }
}
