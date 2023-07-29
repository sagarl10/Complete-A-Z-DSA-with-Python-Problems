a=[1,1,2,3,4,5,2,3,4,5,2,1]
hash={}

for i in a:
    if i not in hash:
        hash[i]=1
    else:
        hash[i]=hash[i]+1

for key in hash:
    print(key,hash[key])