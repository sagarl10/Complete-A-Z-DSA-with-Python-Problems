arr=[7,8,9,1,2,3,4]
import sys
start=0
end=len(arr)-1
mini=sys.maxsize
while start<=end:
    mid=start+(end-start)//2
    if arr[start]<arr[end]:
        mini=min(mini,arr[start])
        break
    if arr[start]<=arr[mid]:
        mini=min(mini,arr[start])
        start=mid+1
    else:
        mini=min(mini,arr[mid])
        end=mid-1

print(mini)



    

