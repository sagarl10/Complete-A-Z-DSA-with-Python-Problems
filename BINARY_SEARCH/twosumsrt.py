nums = [1, 2, 3, 4, 7, 9]
target = 5
start = 0
end = len(nums) - 1

while start <= end:
    sum = nums[start] + nums[end]
    if sum == target:
        print(start, end)
        break
    elif target<sum:
        end=end-1
    else:
        start+=1
else:
    print("No such pair found.")
