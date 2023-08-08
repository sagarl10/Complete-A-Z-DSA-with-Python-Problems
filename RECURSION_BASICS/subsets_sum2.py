def subsetsum(arr,temp,index,final):
    final.append(temp[:])

    for i in range(index,len(arr)):
        if i!=index and arr[i]==arr[i-1]:
            continue
        temp.append(arr[i])
        subsetsum(arr,temp,i+1,final)
        temp.pop()

arr=[1,2,3]
final=[]
subsetsum(arr,[],0,final) 
print(final[:])   
