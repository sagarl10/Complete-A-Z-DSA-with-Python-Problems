num=int(input("Enter number for pali check: "))
temp=num
rev=0
while(num>0):
    rev=rev*10+num%10
    num=num//10
if rev==temp:
    print("Yes! Palindrome")
else:
    print("No its not")        