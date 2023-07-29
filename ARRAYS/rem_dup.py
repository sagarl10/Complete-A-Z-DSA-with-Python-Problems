#THINK NOT ABOUT REMOVING DUPLICATES
#THINK ABOUT HOW TO KEEP UNIQUE ELEMETS AT START OF ARRAY
#11112223333-> 123.....
a=[1,1,1,2,3,4,4,5]
i=0
for j in range(1,len(a)):
    if a[i]!=a[j]:
        i=i+1
        a[i]=a[j]

print(a[:i+1])