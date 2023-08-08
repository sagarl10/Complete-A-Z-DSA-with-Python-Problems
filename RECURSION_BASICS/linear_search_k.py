def search_k(arr,target,index):
    new=[]
    if index==len(arr):
        return new
    if target==arr[index]:
        new.append(index)
    return new+search_k(arr,target,index+1)

a=[1,2,2]
index=0
print(search_k(a,2,index))
    