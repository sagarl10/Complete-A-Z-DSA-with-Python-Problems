def check(arr,index):
    if index==len(arr):
        return True
    if arr[index-1]>arr[index]:
        return False
    return check(arr,index+1)

a=[1,2,3,4,5,6,4]
print(check(a,1))