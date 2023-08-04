a=[[1,2,6],
   [4,5,8],
   [9,11,13]]
target=1
row=0
col=len(a[0])-1
while row<len(a) and col>=0:
    if target==a[row][col]:
        print([row,col])
        break
    elif target<a[row][col]:
        col-=1
    else:
        row+=1
