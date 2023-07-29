def inser(arr,row):
    if row==len(arr):
        return
    j=row
    while j>0 and arr[j-1]>arr[j]:
        arr[j-1],arr[j]=arr[j],arr[j-1]
        j=j-1

    inser(arr,row+1)
    
a=[1,2,4,5,6,2,4,4]    
inser(a,0)
print(a)    
