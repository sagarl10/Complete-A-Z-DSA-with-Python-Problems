def merge(left,right):
    i=0
    j=0
    mixed=[]
    while i<len(left) and j<len(right):
        if left[i]<right[j]:
            mixed.append(left[i])
            i+=1
        else:
            mixed.append(right[j]) 
            j+=1
    while i<len(left):
        mixed.append(left[i])
        i=i+1  
    while j<len(right):
        mixed.append(right[j])
        j+=1
    return mixed                 
def divide(arr):
    if len(arr)==1:
        return arr
    mid=len(arr)//2
    left=divide(arr[:mid])
    right=divide(arr[mid:])
    return merge(left,right)

a=[1,2,5,4,3,6,7,5]
print(divide(a))