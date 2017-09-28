package 最小路径和;

public class Solution {
    /*
     * @param grid: a list of lists of integers
     * @return: An integer, minimizes the sum of all numbers along its path
     */
    public int minPathSum(int[][] grid) {
        if (grid.length == 0) {
            return 0;
        }
        int[][] hash = new int[grid.length][grid[0].length];
        hash[0][0] = grid[0][0];
        for (int i = 0; i < hash.length; i++) {
            for (int j = 0; j < hash[0].length; j++) {
                if (i == 0 && j > 0) {
                    hash[i][j] = hash[i][j - 1] + grid[i][j];
                } else if (j == 0 && i > 0) {
                    hash[i][j] = hash[i - 1][j] + grid[i][j];
                } else if (j > 0) {
                    hash[i][j] = grid[i][j] + (hash[i - 1][j] > hash[i][j - 1] ? hash[i][j - 1] : hash[i - 1][j]);
                }
            }
        }
        return hash[grid.length - 1][grid[0].length - 1];
    }

    public static void main(String[] args) {
        int[][] grid = {{1, 2}, {1, 1}};

        new Solution().minPathSum(grid);
    }
}
