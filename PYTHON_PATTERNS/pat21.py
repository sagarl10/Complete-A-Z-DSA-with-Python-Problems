rows=5
cols=5
for i in range(1,rows+1):
    for j in range(1,cols+1):
        if (i==1 or i==rows or j==1 or j==cols):
            print('*',end=" ")
        else:
            print(" ",end=" ")    
    print()        