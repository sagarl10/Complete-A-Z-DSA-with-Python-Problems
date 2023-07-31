nums=[1,2,3,-1,-2,-3]
arr=[0]*len(nums)
positive=0
negative=1
for i in (nums):
    if i>0:
        arr[positive]=i
        positive+=2
    else:
        arr[negative]=i
        negative+=2
print(arr)            