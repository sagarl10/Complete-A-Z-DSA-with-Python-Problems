rows=6
cols=6

for i in range(rows):
    start=69
    start=start-i
    for j in range(i+1):
        print(chr(start),end=" ")
        start=start+1
    print()