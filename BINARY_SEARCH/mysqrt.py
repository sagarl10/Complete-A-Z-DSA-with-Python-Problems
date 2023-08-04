def sqrt(num):
    if num==0 or num==1:
        return num
    start=1
    end=num
    while start<=end:
        mid=start+(end-start)//2
        if num==mid*mid:
            return mid
        elif num<mid*mid:
            end=mid-1
        else:
            start=mid+1
    return end
print(sqrt(49))            