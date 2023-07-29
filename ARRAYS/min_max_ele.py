a=[1,2,5,9,3,6,8,3,0]
min=a[0]
max=a[0]
minind=len(a)
maxind=0

for i in range(len(a)):
    if a[i]>max:
        max=a[i]
        maxind=i
    if a[i]<min:
        min=a[i]
        minind=i

print(min,max)
print(minind,maxind)