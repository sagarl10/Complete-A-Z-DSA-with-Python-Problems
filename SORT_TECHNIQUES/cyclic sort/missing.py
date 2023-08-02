nums=[6,2,2,5,7,1]
i=0
while i<len(nums):
    correct=nums[i]-1
    if nums[i]<=len(nums) and nums[i]!=nums[correct]:
        nums[i],nums[correct]=nums[correct],nums[i]
    else:
        i+=1
for i in range(len(nums)):
    if nums[i]!=i+1:
        print(i+1)            

#TC-> O(2N)
