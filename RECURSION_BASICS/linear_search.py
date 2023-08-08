def search(arr,target,index):
    if len(arr)==index:
        return -1
    if target==arr[index]:
        return index
    return search(arr,target,index+1)

a=[1,4,3,2,5,6]
target=2
print(search(a,target,0))