package 不同的路径;

public class Solution {
    /*
     * @param m: positive integer (1 <= m <= 100)
     * @param n: positive integer (1 <= n <= 100)
     * @return: An integer
     */
    public int uniquePaths(int m, int n) {
        if (m <= 1 || n <= 1) {
            return 1;
        }
        int[][] hash = new int[m + 1][n + 1];
        hash[1][1] = 1;
        for (int i = 1; i < hash.length; i++) {
            for (int j = 1; j < hash[i].length; j++) {
                if (i > 1) {
                    hash[i][j] += hash[i - 1][j];
                }
                if (j > 1) {
                    hash[i][j] += hash[i][j - 1];
                }
            }
        }
        return hash[m][n];
    }

    public static void main(String[] args) {
        int uniquePaths = new Solution().uniquePaths(3, 80);
        System.out.println(uniquePaths);
    }
}
