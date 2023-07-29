def quick_sort(arr,low,high):
    if low>=high:
        return
    start=low
    end=high
    mid=start+(end-start)//2
    pivot=arr[mid]
    while start<=end:
        while arr[start]<pivot:
            start+=1
        while arr[end]>pivot:
            end-=1
        if start<=end:
            arr[start],arr[end]=arr[end],arr[start]
            start+=1
            end-=1

    quick_sort(arr,low,end)
    quick_sort(arr,start,high)                

a=[1,3,2,4,5,2,1,6,8,3,5]
quick_sort(a,0,len(a)-1)
print(a)    