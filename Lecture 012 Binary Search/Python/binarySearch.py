def binarySearch(arr, size, key):
    start = 0
    end = size - 1
    mid = start + (end - start) // 2
    while start <= end:
        if arr[mid] == key:
            return mid

        if key > arr[mid]:  # moving to right
            start = mid + 1
        else:
            end = mid - 1

        mid = start + ((end - start) // 2)

    return -1


def main():
    n = int(input("Enter the size of the array\n"))
    arr = []

    for i in range(n):
        num = int(input(f"Enter the {i + 1} number\n"))
        arr.append(num)

    key = int(input("Enter the key to be searched\n"))

    result = binarySearch(arr, n, key)
    if result == -1:
        print("Key not found")
    else:
        print("Key is at position " + str(result + 1))


if __name__ == '__main__':
    main()
