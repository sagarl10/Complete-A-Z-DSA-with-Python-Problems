def reverse(arr,start,end):
    while start<=end:
        arr[start],arr[end]=arr[end],arr[start]
        start=start+1
        end=end-1       
#LEFT SHIFT
a=[1,2,3,4,5,6,7,8]
lr=3
n=len(a)
lr=lr%n
reverse(a,0,lr-1)
reverse(a,lr,n-1)
reverse(a,0,n-1)

print(a)

#RIGHT SHIFT
b=[1,2,3,4,5,6,7,7,8,8,9,9,10,11]
reverse(b,len(b)-lr,len(b)-1)
reverse(b,0,len(b)-lr-1)
reverse(b,0,len(b)-1)
print(b)
