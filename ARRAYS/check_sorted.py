a=[1,2,3,4,5,4]
for i in range(len(a)-1):
    if a[i]>=a[i+1]:
        print("false")
        break
else:
    print("True")    
