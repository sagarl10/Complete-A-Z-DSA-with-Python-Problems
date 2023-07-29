rows=6
cols=6
for i in range(rows):
    for j in range(i+1):
        print('*',end=" ")
    for j in range(2*cols-2*(i+1)):
        print(" ",end=" ") 
    for j in range(i+1):
        print('*',end=" ")
    print()
rows=rows-1    
cols=cols-1
for i in range(rows):
    for j in range(cols-i):
        print('*',end=" ")    
    for j in range(2*(i+1)):
        print(" ",end=" ")   
    for j in range(cols-i):
        print('*',end=" ")               
    print()    