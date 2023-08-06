def helper(string,start,end):
    if start>end:
        return "TRUE its palindrome"
    if string[start]!=string[end]:
        return False
    return helper(string,start+1,end-1)

def check_p(string):
    start=0
    end=len(string)-1
    return helper(string,start,end)

print(check_p("MADAM"))
