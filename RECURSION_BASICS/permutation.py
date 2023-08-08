def permutation(string,perm,temp):
    if len(string)==0:
        temp.append(perm)
        return
    for i in range(len(string)):
        ch=string[i]
        newstr=string[0:i]+string[i+1:]
        permutation(newstr,perm+ch,temp)

temp=[]
permutation("abc","",temp)
print(temp)

def permutation_list(lst, perm, temp):
    if len(lst) == 0:
        temp.append(perm)
        return
    for i in range(len(lst)):
        item = lst[i]
        new_lst = lst[:i] + lst[i+1:]
        permutation_list(new_lst, perm + [item], temp)

temp = []
input_list = [1, 2, 3]  # Replace this with your input list
permutation_list(input_list, [], temp)
print(temp)

