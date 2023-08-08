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
arr=[1,2,3,2,4,7]
target=7
arr=sorted(arr)
comb_sum(arr,[],0,0,target,final)
print(final)