a=[1,2,3,4,5]
first=a[0]
for i in range(1,len(a)):
    a[i-1]=a[i]
    if i==len(a)-1:
        a[len(a)-1]=first

print(a)
       