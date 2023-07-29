num=29
import math
n=int(math.sqrt(num))
prime=True
for i in range(2,n+1):
    if(num==2):
        break
    if num%i==0:
        prime=False
        break
if prime is True:
    print('PRIME NUMBER')
else:
    print('NOT A PRIME NUMBER')            