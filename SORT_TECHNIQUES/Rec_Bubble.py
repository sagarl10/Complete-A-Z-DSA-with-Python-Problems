def bubble(arr,row):
    if row==len(arr):
        return arr
    
    for j in range(1,len(arr)-row):
        if arr[j-1]>arr[j]:
            arr[j-1],arr[j]=arr[j],arr[j-1]

    return bubble(arr,row+1)        

print(bubble([1,3,4,2,6,5],0))