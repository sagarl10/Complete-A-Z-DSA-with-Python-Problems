nums=[1,2,3,4,-1,-6,8,9,3,0]
start=0
sstart=-1
send=-1
sum=0
max_sum=nums[0]

for i in range(len(nums)):
    if sum==0:
        start=i 
    sum=sum+nums[i]
    if sum>max_sum:
        max_sum=sum 
        sstart=start
        send=i

    if sum<0:
        sum=0

print(max_sum,sstart,send)