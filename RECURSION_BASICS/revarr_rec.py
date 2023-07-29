def reverarr(arr,start,end):
    if(start>end):
        return arr
    arr[start],arr[end]=arr[end],arr[start]
    
    return reverarr(arr,start+1,end-1)

print(reverarr([1,2,3,4,5],0,4))