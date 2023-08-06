def subsets(arr,sub,index,temp):
    if index==len(arr):
        return list([sub[:]])
        
                
    sub.append(arr[index])
    a=subsets(arr,sub,index+1,temp)
    sub.remove(arr[index])
    b=subsets(arr,sub,index+1,temp)

    return a+b

print(subsets([1,2,3],[],0,[]))