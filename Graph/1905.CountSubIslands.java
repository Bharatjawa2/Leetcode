class Solution {
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int n=grid1.length;
        int c=0;
        int m=grid1[0].length;
        int[][] vis=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid2[i][j]==1 && vis[i][j]==0){
                    if(solve(i,j,vis,grid1,grid2))
                        c++;
                }
            }
        }
        return c;
    }

    boolean solve(int row,int col,int[][] vis,int[][]grid1,int[][] grid2){
        int n=vis.length;
        int m=vis[0].length;
        
        vis[row][col]=1;
        boolean isSub=true;
        if(grid1[row][col]!=1){
            isSub=false;
        }
        int[] delrow={0,0,1,-1};
        int[] delcol={1,-1,0,0};
        
        for(int i=0;i<4;i++){
            int nrow=row+delrow[i];
            int ncol=col+delcol[i];
            if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && grid2[nrow][ncol]==1 && vis[nrow][ncol]==0){
                boolean res=solve(nrow,ncol,vis,grid1,grid2);
                isSub=isSub && res;
            }
        }
        return isSub;
    }
}
