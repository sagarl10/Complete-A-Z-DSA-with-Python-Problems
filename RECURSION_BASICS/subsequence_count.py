def subs(arr,sub,sum,target,index):
    if index>=len(arr):
        if sum==target:
            return 1
        return 0
    sub.append(arr[index])
    left=subs(arr,sub,sum+arr[index],target,index+1)
    sub.remove(arr[index])
    right=subs(arr,sub,sum,target,index+1)
    return left+right

print(subs([1,1,2,3,1,2,0,3,4,4],[],0,2,0))    