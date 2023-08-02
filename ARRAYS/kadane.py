nums=[1,2,3,4,-1,-6,8,9,3,0]
maxsum=nums[0]
sum=0
for i in nums:
    sum=sum+i
    maxsum=max(maxsum,sum)
    if sum<0:
        sum=0

print(maxsum)