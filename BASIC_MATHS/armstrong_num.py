num=153
temp=num
sum=0
digits=len(str(num))
while(num>0):
    sum=sum+(num%10)**digits
    num=num//10
if sum==temp:
    print("ARMSTRONG")
else:
    print("NO")        