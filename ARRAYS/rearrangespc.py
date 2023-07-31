nums=[1,2,3,4,-1,-2,-3,-4,-5,6,7,8]
positives=[]
negatives=[]
for i in nums:
    if i>0:
        positives.append(i)
    else:
        negatives.append(i)
mini=min(len(positives),len(negatives))
for i in range(mini):
    nums[2*i]=positives[i]
    nums[2*i+1]=negatives[i]
maxi=max(len(positives),len(negatives))

if len(positives)>len(negatives):
    for i in range(2*mini,maxi):
        nums[i]=positives[i]
else:
    for i in range(2*mini,maxi):
        nums[i]=negatives[i]

print(nums)        


