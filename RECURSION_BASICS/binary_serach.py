def search(arr,start,end,target):
    if start>end:
        return -1
    mid=start+(end-start)//2
    if target==arr[mid]:
        return mid
    elif target<arr[mid]:
        return search(arr,start,mid-1,target)
    return search(arr,mid+1,end,target)

a=[1,3,5,6,7,8]
target=9
print(search(a,0,len(a)-1,target))