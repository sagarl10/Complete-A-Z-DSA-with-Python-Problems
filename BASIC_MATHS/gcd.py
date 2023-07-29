#gcd(a,b)=gcd(a-b,b) where a>b
#gcd(a,b)=gcd(a%b,b) where a>b

#brute force method

#a=36
#b=35
#gcd=0
#for i in range(min(a,b),0,-1):
#    if(a%i==0) and (b%i==0):
#        gcd=i
#        break
#print(gcd)    #TIME COMPLEXITY O(min(a,b))***

a = 11
b = 13

while (a > 0 and b > 0):
    if a > b:
        a = a % b
    else:
        b = b % a

if a == 0:
    print(b)
else:
    print(a)
#time complexity log(min(a,b))