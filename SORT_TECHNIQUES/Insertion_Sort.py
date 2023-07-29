#Check array of size 1-> check size of 2 and sort by swapping->....
#Think of whether the element in perfect position if not swap
#Think of right angle traingle
#Time complexity O(N^2)
a=[1,3,2,5,4,7,3,2,5,7,9]
for i in range(len(a)):
    j=i
    while j>0 and a[j]<a[j-1]:
        a[j],a[j-1]=a[j-1],a[j]
        j=j-1

print(a)
