a=[1,2,3,4,5,6,7,9]
target=5
start=0
end=len(a)-1
while start<=end:
    mid=start+(end-start)//2
    if target==a[mid]:
        print(mid)
        break
    elif target>a[mid]:
        start=mid+1
    else:
        end=mid-1    
