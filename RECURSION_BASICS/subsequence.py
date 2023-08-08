def subsequence(arr,sub,index):
    if index>=len(arr):
        print(sub)
        return
    sub.append(arr[index])
    subsequence(arr,sub,index+1)
    sub.remove(arr[index])
    subsequence(arr,sub,index+1)

subsequence([1,2,2],[],0)