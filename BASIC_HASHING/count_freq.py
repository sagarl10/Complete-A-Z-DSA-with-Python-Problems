#Brute force
a=[1,2,1,5,2,5,2,4,4,3]
visited=[False]*len(a)
for i in range(len(a)):
    if visited[i] is True:
        continue
    count=1
    for j in range(i+1,len(a)):
        if a[i]==a[j]:
            count=count+1
            visited[j]=True
    print(a[i],count)        

