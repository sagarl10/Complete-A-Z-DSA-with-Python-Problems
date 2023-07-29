a=[1,2,3,4,5,6,7,8]
d=3
n=len(a)
k=d%n
temp=a[:k]
j=0
for i in range(k,len(a)):
    a[i-k]=a[i]

    if i>=n-k:
        a[i]=temp[j]
        j=j+1

print(a)