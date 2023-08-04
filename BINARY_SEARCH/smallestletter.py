letters=['c','d','e','f']
target='f'
start=0
end=len(letters)-1
if target<letters[start] or target>letters[end]:
    print(letters[0])
while start<=end:
    mid=start+(end-start)//2
    if target<letters[mid]:
        end=mid-1
    else:
        start=mid+1
print(letters[start%len(letters)])                