def merge(left,right):
    i=0
    j=0
    merged_arr=[]
    while i<len(left) and j<len(right):
        if right[j]<left[i]:
            merged_arr.append(right[j])
            j=j+1
        else:
            merged_arr.append(left[i])
            i=i+1

    while i<len(left):
        merged_arr.append(left[i])
        i=i+1
    while j<len(right):
        merged_arr.append(right[j])  
        j=j+1 

    return merged_arr        

def divide(arr):
    if len(arr)==1:
        return arr
    mid=len(arr)//2
    left=divide(arr[0:mid])
    right=divide(arr[mid:])
    return merge(left,right)

a=[1,2,4,6,4,3,6,3,36,8,8]
op=divide(a)
print(op)