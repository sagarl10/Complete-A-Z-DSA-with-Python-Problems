rows=4
cols=4
for i in range(1,rows+1):
    for j in range(1,i+1):
        print(j,end=" ")
    for j in range(2*cols-2*i):
        print(' ',end=" ")
    for j in range(i,0,-1):
        print(j,end=" ")
    print()            