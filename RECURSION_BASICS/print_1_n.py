def print_oneto_n(i,n):
    if i>n:
        return
    print(i)
    print_oneto_n(i+1,n)

print_oneto_n(1,10)