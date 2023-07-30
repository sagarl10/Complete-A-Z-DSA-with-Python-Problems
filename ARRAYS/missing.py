a=[1,2,3,5,6,7]
n=7
exact_sum=n*(n+1)/2
sum=0
for i in a:
    sum=sum+i

missing=exact_sum-sum
print(int(missing))    
