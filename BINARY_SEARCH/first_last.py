arr=[1,2,3,3,3,4,5,5,5,5,6]
target=5
def first(arr,s,e,target):
    first=-1
    while s<=e:
        mid=s+(e-s)//2
        if target==arr[mid]:
            first=mid
            e=mid-1
        elif target<arr[mid]:
            e=mid-1
        else:
            s=mid+1
    return first

def last(arr,start,end,target):
    last=-1
    while start<=end:
        mid=start+(end-start)//2
        if target==arr[mid]:
            last=mid
            start=mid+1
        elif target<arr[mid]:
            end=mid-1
        else:
            start=mid+1
    return last

first=first(arr,0,len(arr)-1,target)
last=last(arr,0,len(arr)-1,target)
print([first,last])        

                        