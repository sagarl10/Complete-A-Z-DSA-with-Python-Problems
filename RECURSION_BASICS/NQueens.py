def issafer(row,col,board):
    temp_r=row
    temp_c=col
    for i in range(col+1):
        if board[row][i]=='Q':
            return False

    while temp_r>=0 and temp_c>=0:
        if board[temp_r][temp_c]=='Q':
            return False
        temp_r-=1
        temp_c-=1
    while row<len(board) and col>=0:
        if board[row][col]=='Q':
            return False
        temp_r+=1
        temp_c-=1
    return True        

def solve(board,ans,col):
    if col==len(board):
        ans.append([board[:]])
        return
    for row in range(len(board)):
        if issafer(row,col,board):
            board[row][col]='Q'
            solve(board,ans,col+1)
            board[row][col]='.'

board=[['.']*4]*4
ans=[]
solve(board,ans,0)
print(board)

