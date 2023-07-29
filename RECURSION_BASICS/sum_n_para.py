def sum_n(n,sum):
    if n==0:
        print(sum)
        return
    sum_n(n-1,sum+n)

sum_n(20,0)  

#Parameteroized recursion where output needs to be printed is passed in parameters of function

#Functional recursion no need to send op to be printed parameter, op will be returned through return keyword