#find the number that appears once and others twice
# XOR operator
# 1^1=0 2^2=0
# 0^0=0
# 1^0=1 5^0=5
# 0^1=1

a=[1,1,2,2,3,3,4,4,5,5,6,6,7]
xor=0

for i in a:
    xor=i^xor

print(xor)
