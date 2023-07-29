a=[1,4,2,6,7,4,5,3,9,1]

for i in range(len(a)):
    for j in range(1,len(a)-i):
        if a[j]<a[j-1]:
            a[j-1],a[j]=a[j],a[j-1]

print(a)