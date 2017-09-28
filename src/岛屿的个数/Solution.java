package 岛屿的个数;

public class Solution {
    /*
     * @param grid: a boolean 2D matrix
     * @return: an integer
     */
    public int numIslands(boolean[][] grid) {

        int count = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j]) {
                    count++;
                    dfs(grid, i, j);
                }
            }
        }
        return count;
    }

    private void dfs(boolean[][] grid, int x, int y) {
        if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length || !grid[x][y]) {
            return;
        }
        grid[x][y] = false;
        dfs(grid, x, y - 1);
        dfs(grid, x - 1, y);
        dfs(grid, x, y + 1);
        dfs(grid, x + 1, y);
    }
}
