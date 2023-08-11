def solve(board,ans,col,left_row,upper_diag,lower_diag,n):
    if col==n:
        ans.append([''.join(i) for i in board])
        return
    for row in range(n):
        if left_row[row]==0 and upper_diag[n-1+col-row]==0 and lower_diag[row+col]==0:
            board[row][col]='Q'
            left_row[row]=1
            upper_diag[n-1+col-row]=1
            lower_diag[row+col]=1
            solve(board,ans,col+1,left_row,upper_diag,lower_diag,n)
            board[row][col]='.'
            left_row[row]=0
            upper_diag[n-1+col-row]=0
            lower_diag[row+col]=0
n=4
board=[['.' for j in range(n)] for i in range(n)]
left_row={i:0 for i in range(n)}
upper_diag={i:0 for i in range(2*n-1)}
lower_diag={i:0 for i in range(2*n-1)}
ans=[]
solve(board,ans,0,left_row,upper_diag,lower_diag,n)
print(ans)
