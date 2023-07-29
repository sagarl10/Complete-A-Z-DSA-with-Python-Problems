rows=5
cols=5
for i in range(rows,0,-1):
    start=0
    for j in range(i):
        a=65+start
        start=start+1
        print(chr(a),end=" ")
    print()    
