n=5
secondlast=0
last=1
print(secondlast)
print(last)

while n>1:
    cur=secondlast+last
    print(cur)
    secondlast=last
    last=cur
    n=n-1