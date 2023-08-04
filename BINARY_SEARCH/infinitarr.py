arr=[1,2,3,4,6,7,8,9,10]

def bs(arr,start,end,target):
    while start<=end:
        mid=start+(end-start)//2
        if target==arr[mid]:
            print(mid)
            break
        elif target>arr[mid]:
            start=mid+1
        else:
            end=mid-1  
#array we dont know the length
start=0
end=1
target=2
while target>arr[end]:
    temp=end
    end=(end-start+1)*2+end
    start=temp+1
bs(arr,start,end,target)    

