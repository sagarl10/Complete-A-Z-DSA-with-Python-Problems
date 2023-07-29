rows=4
cols=4
for i in range(rows):
    for j in range(cols-i+1):
        print(" ",end=" ")
        a=64
    for j in range(2*i+1):
        if(j<=i):
            a=a+1
            print(chr(a),end=" ")
        else:
            a=a-1
            print(chr(a),end=" ")

    print()  