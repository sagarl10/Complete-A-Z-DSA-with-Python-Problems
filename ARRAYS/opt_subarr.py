a=[1,2,3,4,0,0,0,0,0,0,4,5,6,7,8,1]
maxlen=0
sum=0
target=5

j=0
for i in range(len(a)):
    sum=sum+a[i]
    while sum>target:
        sum=sum-a[j]
        j=j+1
    if sum==target:
        maxlen=max(maxlen,i+1-j) 

print(maxlen)
