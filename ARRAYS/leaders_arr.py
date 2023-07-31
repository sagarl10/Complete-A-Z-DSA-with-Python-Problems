#what is leader in array?
#the elements which should be higher than elements in right of it
nums=[1,2,4,3,2,1]
leaders=[]
max=0
for i in range(len(nums)-1,-1,-1):
    if nums[i]>max:
        max=nums[i]
        leaders.append(max)

print(leaders)