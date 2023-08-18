def comb_sum(arr,temp,index,sum,target,final):
    if sum==target:
        final.append(temp[:])
        return
    for i in range(index,len(arr)):
        if sum>target:
            break
        if i!=index and arr[i]==arr[i-1]:
            continue
        temp.append(arr[i])
        comb_sum(arr,temp,i+1,sum+arr[i],target,final)
        temp.pop()

final=[]
arr=[1,1,1,2,2]
target=4
arr=sorted(arr)
comb_sum(arr,[],0,0,target,final)
print(final)