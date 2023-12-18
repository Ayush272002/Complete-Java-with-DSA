//
// Created by ayush on 17/12/2023.
//
#include "iostream"
using namespace std;

int binarySearch(int arr[], int size, int key)
{
    int start =0;
    int end =size-1;
//  int mid = (start+end)/2;  correct if they are small but if they exceed the range then it would throw and error
    int mid = start + ((end-start)/2);
    while(start<=end)
    {
        if(arr[mid]==key)
            return mid;

        if(key>arr[mid]) //moving to right part
            start = mid+1;
        else
            end = mid-1;

        mid=start + ((end-start)/2);
    }
    return -1;
}

int main()
{
    int n,key;
    cout<<"Enter the size of the array\n";
    cin>>n;
    int arr[n];
    for(int i=0; i<n;i++)
    {
        cout<<"Enter the "<<i+1<<" number"<<endl;
        cin>>arr[i];
    }
    cout<<"Enter the key to be searched\n";
    cin>>key;
    if(binarySearch(arr,n,key)==-1)
        cout<<"Key not found\n";
    else
        cout<<"Key is at "<<binarySearch(arr,n,key)+1<<" position";

    return 0;
}

