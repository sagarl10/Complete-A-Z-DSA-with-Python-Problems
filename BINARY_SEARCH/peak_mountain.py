arr=[1,2,3,4,5,6,3,2,1]
#find peak element in mountain array
start=0
end=len(arr)-1
while start<end:
    mid=start+(end-start)//2
    if arr[mid]>arr[mid+1]:
        end=mid
    else:
        start=mid+1
print(arr[start],arr[end])