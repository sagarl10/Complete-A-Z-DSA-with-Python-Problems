def ispali(start,end,string):
    while start<=end:
        if string[start]!=string[end]:
            return False
    return True    

def pali(string,index,ans,temp):
    if index==len(string):
        ans.append(temp[:])
        return
    
    for i in range(index,len(string)):
        if ispali(index,i,string):
            temp.append(string[index:i+1])
            pali(string,i+1,ans,temp)
            temp.pop()

ans=[]
string="ssaa"
pali(string,0,ans,[])
print(ans)

