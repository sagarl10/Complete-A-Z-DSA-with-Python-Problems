def solve(maze,i,j,path,visited,diri,dirj,n):
    if i==n-1 and j==n-1:
        print(path)
        return
    string="URDL"
    for k in range(4):
        nexti=i+diri[k]
        nextj=j+dirj[k]
        if 0<=nexti<n and 0<=nextj<n and maze[nexti][nextj]==1 and visited[nexti][nextj]==0:
            visited[nexti][nextj]=1
            solve(maze,nexti,nextj,path+string[k],visited,diri,dirj,n)
            visited[nexti][nextj]=0
    return -1        

maze=[[1,0,1,1],
      [1,1,0,0],
      [1,1,1,0],
      [1,1,1,1]]
visited=[[0 for i in range(len(maze))] for i in range(len(maze))]
diri=[-1,0,1,0]
dirj=[0,1,0,-1]
print(solve(maze,0,0,"",visited,diri,dirj,len(maze)))