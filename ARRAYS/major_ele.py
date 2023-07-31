nums=[1,1,1,2,3,4,4,5,1,1,1]
d={}
for i in nums:
    if i in d:
        d[i]=d[i]+1
        if d[i]>len(nums)//2:
            print(i)
            break
    else:
        d[i]=1
if len(nums)==1:
    print(nums[0])    
