# AS THE NAME SUGGESTS SELECT THE MINIMUM VALUE AND PUT IT IN FIRST INDEX, MEANT SWAP WITH FIRST INDEX
a=[1,4,3,5,6,8,1,2]

for i in range(len(a)):
    min=i
    for j in range(i+1,len(a)):
        if a[j]<a[min]:
            min=j
    a[i],a[min]=a[min],a[i] 

print(a)