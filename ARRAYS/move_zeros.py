a=[1,0,2,3,0,0,1,2,0]
j=0
for i in range(0,len(a)):
    if a[i]!=0:
        a[j]=a[i]
        j=j+1

for i in range(j,len(a)):
    a[i]=0
print(a)         



