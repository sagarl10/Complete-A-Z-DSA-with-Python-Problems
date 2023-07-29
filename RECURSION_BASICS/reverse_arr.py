a=[1,2,3,4,5,7]
start=0
end=len(a)-1
while(start<end):
    a[start],a[end]=a[end],a[start]
    start=start+1
    end=end-1
print(a)    