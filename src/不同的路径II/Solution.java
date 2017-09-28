package 不同的路径II;

public class Solution {
    /*
     * @param obstacleGrid: A list of lists of integers
     * @return: An integer
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0].length == 0) {
            return 0;
        }
        int[][] hash = new int[obstacleGrid.length + 1][obstacleGrid[0].length + 1];
        hash[1][1] = 1;
        for (int i = 1; i < hash.length; i++) {
            for (int j = 1; j < hash[0].length; j++) {
                if (i > 1 && obstacleGrid[i - 2][j - 1] != 1) {
                    hash[i][j] += hash[i - 1][j];
                }
                if (j > 1 && obstacleGrid[i - 1][j - 2] != 1) {
                    hash[i][j] += hash[i][j - 1];
                }
            }
        }
        return hash[obstacleGrid.length][obstacleGrid[0].length];
    }
}
