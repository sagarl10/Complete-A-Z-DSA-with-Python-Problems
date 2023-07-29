def pali(word,start,end):
    if start>end:
        return True
    if(word[start]==word[end]):
        return pali(word,start+1,end-1)
    else:
        return False

if pali("MADAM",0,4) is True:
    print("PALI")
else:
    print("NOT A PALI")    