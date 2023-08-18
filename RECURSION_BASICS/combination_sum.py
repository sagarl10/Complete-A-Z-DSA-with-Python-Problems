def comb_sum(arr,temp,target,index):
    if index==len(arr):
        if target==0:
            print(temp)
        return

    if arr[index]<=target:
        temp.append(arr[index])
        comb_sum(arr,temp,target-arr[index],index)
        temp.remove(arr[index])
    comb_sum(arr,temp,target,index+1)

comb_sum([1,1,1,2,2],[],4,0)