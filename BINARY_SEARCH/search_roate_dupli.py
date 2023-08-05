arr=[4,8,9,1,2,3,4,4]
target=2
start=0
end=len(arr)-1
while start<=end:
    mid=start+(end-start)//2
    if target==arr[mid]:
        print(mid)
        break
    #below 4 extra lines for duplicated roate sorted array
    if arr[start]==arr[mid] and arr[mid]==arr[end]:
        start=start+1
        end=end-1
        continue
    if arr[start]<=arr[mid]:
        if arr[start]<=target<=arr[mid]:
            end=mid-1
        else:
            start=mid+1
    else:
        if arr[mid]<=target<=arr[end]:
            start=mid+1
        else:
            end=mid-1
