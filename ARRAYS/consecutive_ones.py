a=[0,1,1,0,1,1,1,1,0]
cnt=0
mx=0
for i in a:
    if i==1:
        cnt=cnt+1
        mx=max(mx,cnt)

    else:
        cnt=0

print(mx)
