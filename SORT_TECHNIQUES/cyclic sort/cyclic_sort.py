# when the elements in array are range from 1 to N, then go for cyclic sort
# Check whether the elements in correct position if not swap the elements

nums=[2,1,5,4,3]
i=0
while i<len(nums):
    correct=nums[i]-1
    if nums[i]!=nums[correct]:
        nums[i],nums[correct]=nums[correct],nums[i]
    else:
        i+=1

print(nums)