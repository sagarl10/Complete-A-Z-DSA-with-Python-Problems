a=[1,3,5,8,9]
max=a[0]
min=a[0]
for i in range(1,len(a)):
    if a[i]>max:
        max=a[i]
    if a[i]<min:
        min=a[i]    

print(max,min)