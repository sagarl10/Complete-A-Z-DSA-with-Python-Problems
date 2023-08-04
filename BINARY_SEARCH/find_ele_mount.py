def peak(arr,start,end):
    while start<end:
        mid=start+(end-start)//2
        if arr[mid]>arr[mid+1]:
            end=mid
        else:
            start=mid+1
    return start

def bin_search(arr,start,end,target):
    isasc=arr[start]<arr[end]
    while start<=end:
        mid=start+(end-start)//2
        if target==arr[mid]:
            return mid
        if isasc:
            if target<arr[mid]:
                end=mid-1
            else:
                start=mid+1
        else:
            if target<arr[mid]:
                start=mid+1
            else:
                end=mid-1
    return -1
                            
arr=[1,2,3,4,3,2,1]
target=1
peak_index=peak(arr,0,len(arr)-1)
ans=bin_search(arr,0,peak_index,target)
if ans==-1:
    ans=bin_search(arr,peak_index+1,len(arr)-1,target)
print(ans)    
