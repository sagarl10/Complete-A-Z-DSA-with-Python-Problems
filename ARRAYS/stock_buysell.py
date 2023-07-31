prices=[5,3,4,1,4,4,7]
mini=prices[0]
max_profit=0
for i in range(1,len(prices)):
    profit=prices[i]-mini
    max_profit=max(max_profit,profit)
    mini=min(mini,prices[i])
print(max_profit)    
