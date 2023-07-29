rows=5
cols=5
for i in range(rows):
    for j in range(cols-i):
        print('*',end=" ")
    for j in range(2*i):
        print(' ',end=" ")
    for j in range(cols-i):
        print('*',end=" ")
    print()

for i in range(rows):
    for j in range(i+1):
        print('*',end=" ")
    for j in range(2*cols-2*(i+1)):
        print(' ',end=" ")
    for j in range(i+1):
        print('*',end=" ")
    print()  