class Solution {
    public int numIslands(char[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int[][] vis=new int[n][m];
        int c=0;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]=='1' && vis[i][j]==0){
                    solve(i,j,vis,grid);
                    c++;
                }
            }
        }
        return c;
    }


    void solve(int row,int col,int[][] vis,char[][] grid){
        vis[row][col]=1;
        int n=grid.length;
        int m=grid[0].length;
        int[] delrow={0,0,1,-1};
        int[] delcol={1,-1,0,0};
        for(int i=0;i<4;i++){
            int nrow=row+delrow[i];
            int ncol=col+delcol[i];
            if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && grid[nrow][ncol]=='1' && vis[nrow][ncol]==0){
                solve(nrow,ncol,vis,grid);
            }
        }
    }
}
