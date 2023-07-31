a=[1,2,3,4,5,6]
target=3
d={}
for i in range(len(a)):
    if target-a[i] in d:
        print([d[target-a[i]],i])
        break
    else:
        d[a[i]]=i
