a=[[1,2,3],[4,5,6],[7,8,9]]
col=len(a[0])
target=2
start=0
end=len(a)*col-1
while start<=end:
    mid=start+(end-start)//2
    if target==a[mid//col][mid%col]:
        print([int(mid/col),mid%col])
        break
    elif target>a[int(mid//col)][mid%col]:
        start=mid+1
    else:
        end=mid-1
