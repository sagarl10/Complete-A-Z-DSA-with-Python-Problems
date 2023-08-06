def quick(arr,low,high):
    if low>high:
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
    quick(arr,low,end)    
    quick(arr,start,high)   
    return arr

a=[1,3,4,2,8,5,7]      
print(quick(a,0,len(a)-1))   
