def subs(arr,sub,sum,index,sums):
    if index>=len(arr):
        sums.append(sum)
        return
    sub.append(arr[index])
    subs(arr,sub,sum+arr[index],index+1,sums)
    sub.remove(arr[index])
    subs(arr,sub,sum,index+1,sums)    

sums=[]
subs([1,2,3],[],0,0,sums)    
print(sorted(sums))