a=[1,2,3,4,0,0,0,0,0,0,4,5,6,7,8,1]
maxlen=0
d={}
sum=0
target=8
for i in range(len(a)):
    sum=sum+a[i]
    if sum==target:
        maxlen=max(maxlen,i+1)

    rem=sum-target
    if rem in d:
        maxlen=max(maxlen,i-d[rem])

    if sum not in d:
        d[sum]=i

print(maxlen)