arr=[7,8,9,1,2,3,4]
import sys
start=0
end=len(arr)-1
mini=sys.maxsize
rt_cnt=-1
while start<=end:
    mid=start+(end-start)//2
    if arr[start]<arr[end]:
        if arr[start]<mini:
            mini=arr[start]
            rt_cnt=start
        break
    if arr[start]<=arr[mid]:
        if arr[start]<mini:
            mini=arr[start]
            rt_cnt=start
            start=mid+1
    else:
        if arr[mid]<mini:
            mini=arr[mid]
            rt_cnt=mid
            end=mid-1

print(mini,rt_cnt)



    

