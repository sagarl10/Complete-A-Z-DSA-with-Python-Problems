a=[1,2,3,3,4,5,6]
b=[1,2,3,3]
i=0
j=0
c=[]

while i<len(a) and j<len(b):
    if a[i]<b[j]:
        i=i+1
    elif b[j]<a[i]:
        j=j+1
    else:
        c.append(a[i])
        i=i+1
        j=j+1

print(c)