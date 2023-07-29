import math
num=36
n=int(math.sqrt(num))
print(n)
facts=[]
for i in range(1,n+1):
    if(num%i==0):
        facts.append(i)
        if(num//i!=i):
            facts.append(num//i)

print(sorted(facts))
