nums=[1,2,3,5,7,8,9,15]
target=12
start=0
end=len(nums)-1
ceil=-1;
while start<=end:
    mid=start+(end-start)//2
    if nums[mid]==target:
        print(nums[mid])
        break
    elif target<nums[mid]:
        ceil=mid;
        end=mid-1
    else:
        start=mid+1
print(nums[ceil])        

