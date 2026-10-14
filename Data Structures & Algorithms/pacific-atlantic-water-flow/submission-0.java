class Solution {
    private int rows;
    private int cols;
    private int[][] heights;
    private boolean[][] pacific;
    private boolean[][] atlantic;
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        this.heights = heights;
        rows = heights.length;
        cols = heights[0].length;

        pacific = new boolean[rows][cols];
        atlantic = new boolean[rows][cols];

        for (int i = 0; i < rows; i++) {
            dfs(i, 0, pacific);
            dfs(i, cols - 1, atlantic);
        }
        for (int i = 0; i < cols; i++) {
            dfs(0, i, pacific);
            dfs(rows - 1, i, atlantic);
        }
        List<List<Integer>> result = new ArrayList<>();
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (pacific[r][c] && atlantic[r][c]) {
                    result.add(Arrays.asList(r, c));
                }
            }
        }

        return result;
    }

    private void dfs(int r, int c, boolean[][] visited) {
        if (visited[r][c])
            return;
        visited[r][c] = true;

        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        for (int[] dir : directions) {
            int nr = r + dir[0];
            int nc = c + dir[1];
            if (nr < 0 || nc < 0 || nr >= rows || nc >= cols)
                continue;
            
            if (heights[r][c] <= heights[nr][nc]) {
                dfs(nr, nc, visited);
            }
        }
    }
}
