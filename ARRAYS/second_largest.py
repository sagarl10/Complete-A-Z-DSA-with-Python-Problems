a=[1,2,3,10,32]
largest=a[0]
slargest=-1
index=0
sindex=-1

for i in range(1,len(a)):
    if(a[i]>largest):
        slargest=largest
        sindex=index
        largest=a[i]
        index=i
    
    elif a[i]<largest and a[i]>slargest:
        slargest=a[i]
        sindex=i


print(sindex,slargest)