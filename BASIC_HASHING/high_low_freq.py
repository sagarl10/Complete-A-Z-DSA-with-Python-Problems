a=[1,1,2,3,4,5,5,6,6,7,8,6]
hash={}
for i in a:
    if i not in hash:
        hash[i]=1
    else:
        hash[i]=hash[i]+1
max=0
min=len(a)
maxkey=0
minkey=0
for key,value in hash.items():
    if value>max:
        max=value
        maxkey=key
    if value<min:
        min=value
        minkey=key

print(minkey,maxkey)        



