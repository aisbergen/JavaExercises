public class Solution {
    public int OrangesRotting(int[][] grid) {
       int n = grid.Length;
       int m = grid[0].Length;

       Queue<(int row, int col, int time)> q = new Queue<(int, int, int)>();

       int[][] vis = new int[n][];
       for (int i = 0; i < n; i++) vis[i] = new int[m];

       int ctnFresh =0;

       for(int i=0; i<n; i++){
        for(int j=0; j<m; j++){
            if(grid[i][j]==2){
                q.Enqueue((i, j, 0));
                vis[i][j]=2;
            }
            else{
                vis[i][j] =0;
            }
            if(grid[i][j]==1)ctnFresh++;
        }
       }

        //BFS
       int tm = 0;
       int[] drow = {-1, 0, +1, 0};
       int[] dcol = {0, 1, 0, -1};

       int ctnRotten =0;

       while(q.Count > 0){
        var (r, c, t) = q.Dequeue();
        tm = Math.Max(tm, t);

        for (int i = 0; i < 4; i++) {
            int nrow = r + drow[i];
            int ncol = c + dcol[i];

        if (nrow >= 0 && nrow < n &&
                    ncol >= 0 && ncol < m &&
                    vis[nrow][ncol] == 0 &&
                    grid[nrow][ncol] == 1)
                {
                    vis[nrow][ncol] = 2;     
                    ctnRotten++;
                    q.Enqueue((nrow, ncol, t + 1));
                }
            
        }
    }

    return ctnFresh == ctnRotten ? tm : -1;
    
    }
    

}