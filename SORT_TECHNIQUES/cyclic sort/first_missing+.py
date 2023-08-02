nums=[1,2,3,4,5]
i=0
n=len(nums)
while i<n:
    correct=nums[i]-1
    if 1<=nums[i]<=n and nums[i]!=nums[correct]:
        nums[i],nums[correct]=nums[correct],nums[i]
    else:
        i+=1

for i in range(n):
    if nums[i]!=i+1:
        print(i+1)
        break
else:
    print(n+1)    
