def power(n):
    if n==1:
        return True
    if n%3!=0:
        return False
    return power(n//3)

n=10
print(power(n))