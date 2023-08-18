
def comb(arr,temp,target,sum,ans,index,cnt,k):
    if sum==target and cnt==k:
        ans.append(temp[:])
        return

    for i in range(index,len(arr)):
        if sum>target:
            break
        temp.append(arr[i])
        comb(arr,temp,target,sum+arr[i],ans,i+1,cnt+1,k)
        temp.pop()
ans=[]
arr=[i for i in range(1,10)]
comb(arr,[],7,0,ans,0,0,2)  
print(ans) 
            