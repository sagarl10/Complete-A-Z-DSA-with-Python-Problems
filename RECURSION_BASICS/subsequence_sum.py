def subs(arr,sub,sum,target,index):
    if index>=len(arr):
        if sum==target:
            print(sub,sum)
        return
    sub.append(arr[index])
    subs(arr,sub,sum+arr[index],target,index+1)
    sub.remove(arr[index])
    subs(arr,sub,sum,target,index+1)    

subs([1,1,2,3,1,2,0,3,4,4],[],0,2,0)    