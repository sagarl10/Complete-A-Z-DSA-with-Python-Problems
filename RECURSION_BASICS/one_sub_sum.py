def subs(arr,sub,sum,target,index):
    if index>=len(arr):
        if sum==target:
            print(sub,sum)
            return True
        return False
    sub.append(arr[index])
    if subs(arr,sub,sum+arr[index],target,index+1)==True:
        return True
    sub.remove(arr[index])
    if subs(arr,sub,sum,target,index+1):
        return True
    return    

print(subs([1,1,2,3,1,2,0,3,4,4],[],0,2,0))    