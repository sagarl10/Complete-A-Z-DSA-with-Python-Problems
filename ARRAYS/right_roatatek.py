a=[1,2,3,4,5,6,7,8]
d=3
n=len(a)
k=d%n
temp=a[n-k:]
j=0

for i in range(n-k-1,-1,-1):
    a[i+k]=a[i]

for i in range(k):
    a[i]=temp[j]
    j=j+1

print(a)