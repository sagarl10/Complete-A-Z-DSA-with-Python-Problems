def print_n_1(n):
    if n<=0:
        return
    print(n)
    print_n_1(n-1)

print_n_1(10)    
        