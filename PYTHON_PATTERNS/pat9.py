rows=5
cols=5
for i in range(rows):
    for j in range(cols-i+1):
        print(" ",end="")
    for j in range(2*i+1):
        print('*',end="")
    print()
    
for i in range(rows,0,-1):
    for j in range(cols-i): 
        print(" ",end="")             
    for j in range(1,2*i):
        print('*',end="")
    print()     