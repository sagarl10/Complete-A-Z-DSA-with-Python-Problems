def subsequence(arr,sub,index):
    if index>=len(arr):
        print(sub)
        return
    
    subsequence(arr,sub.append(arr[index]),index+1)
    sub.remove(arr[index])
    subsequence(arr,sub,index+1)

subsequence([1,2,3],[],0)