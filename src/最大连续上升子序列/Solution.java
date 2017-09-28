package 最大连续上升子序列;

public class Solution {
    /*
     * @param A: An array of Integer
     * @return: an integer
     */
    public int longestIncreasingContinuousSubsequence(int[] A) {
        if (A == null) {
            return 0;
        }
        if (A.length < 3) {
            return A.length;
        }
        boolean trend = A[1] > A[0];
        int max = 2;
        int count = 2;
        for (int i = 1; i < A.length - 1; i++) {
            if (A[i + 1] > A[i] != trend) {
                count = 2;
                trend = !trend;
            } else {
                count++;
                if (count > max) {
                    max = count;
                }
            }
        }
        return max;
    }
}
