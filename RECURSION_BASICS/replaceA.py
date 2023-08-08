def replace(string,index):
    new_str=""
    if index==len(string):
        return new_str
    if string[index]!='a':
        new_str=new_str+string[index]
    return new_str+replace(string,index+1)   

print(replace("baaccad",0)) 
    
