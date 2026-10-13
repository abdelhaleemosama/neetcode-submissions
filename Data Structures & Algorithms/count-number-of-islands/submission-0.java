class Solution {
    public int numIslands(char[][] grid) {
        int num = 0;
        for(int i = 0;i<grid.length;i++){
            for(int j =0;j<grid[0].length;j++){
                if(grid[i][j] == '0') continue;
                num+= dfs(grid,i,j);
            }
        }
        return num;
    }
    private int dfs(char[][]grid,int r,int c){
        int[][] directions = {{0,1},{1,0},{-1,0},{0,-1}};
        for(int[] dir : directions){
            int[]curr = {dir[0]+r,dir[1]+c};
            if(dir[0]+r == -1 || dir[1]+c == -1) continue;
            if(dir[0]+r >= grid.length || dir[1]+c >= grid[0].length) continue;

            if(grid[dir[0]+r][dir[1]+c] == '0') continue;
            if(grid[dir[0]+r][ dir[1]+c] == '1'){
                grid[dir[0]+r][ dir[1]+c] = '0';
                dfs(grid, dir[0]+r, dir[1]+c);
            }
            
        }
        return 1;
    }
}
