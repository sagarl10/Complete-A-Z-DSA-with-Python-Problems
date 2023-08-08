def comb_sum(arr,temp,sum,target,index):
    if index==len(arr):
        if target==sum:
            print(temp)
        return

    if sum<=target:
        temp.append(arr[index])
        comb_sum(arr,temp,sum+arr[index],target,index)
        temp.remove(arr[index])
    comb_sum(arr,temp,sum,target,index+1)

comb_sum([1,2,3,2,4,7],[],0,7,0)