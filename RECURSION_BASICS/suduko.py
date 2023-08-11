def canifill(board,row,col,char):
    for i in range(9):
        if board[row][i]==char:
            return False
        if board[i][col]==char:
            return False
        if board[3 * (row // 3) + i // 3][3 * (col // 3) + i % 3] == char:
            return False
    return True
def solve(board):
    for i in range(len(board)):
        for j in range(len(board)):
            if board[i][j]=='.':
                for char in '123456789':
                    if canifill(board,i,j,char)==True:
                        board[i][j]=char
                        if solve(board):
                            return True
                        else:
                            board[i][j]='.'
                return False                
    return True                        

board = [
        ["9", "5", "7", ".", "1", "3", ".", "8", "4"],
        ["4", "8", "3", ".", "5", "7", "1", ".", "6"],
        [".", "1", "2", ".", "4", "9", "5", "3", "7"],
        ["1", "7", ".", "3", ".", "4", "9", ".", "2"],
        ["5", ".", "4", "9", "7", ".", "3", "6", "."],
        ["3", ".", "9", "5", ".", "8", "7", ".", "1"],
        ["8", "4", "5", "7", "9", ".", "6", "1", "3"],
        [".", "9", "1", ".", "3", "6", ".", "7", "5"],
        ["7", ".", "6", "1", "8", "5", "4", ".", "9"],
    ]
solve(board)
print(board)