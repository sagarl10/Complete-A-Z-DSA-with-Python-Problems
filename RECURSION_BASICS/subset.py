def subset(string,new,index):
    li=[]
    if index==len(string):
        return [new]
    new=new+string[index]
    left=subset(string,new,index+1)
    new=new.replace(string[index],'')
    right=subset(string,new,index+1)
    return left+right
    
print(subset("sag","",0))   