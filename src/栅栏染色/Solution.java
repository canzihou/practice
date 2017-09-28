package 栅栏染色;

public class Solution {
    /*
     * @param n: non-negative integer, n posts
     * @param k: non-negative integer, k colors
     * @return: an integer, the total number of ways
     */
    public int numWays(int n, int k) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return k;
        }
        if (n == 2) {
            return k * k;
        }
        int pre = k;
        int now = k * k;
        for (int i = 3; i <= n; i++) {
            int tmp = now;
            now = (pre + now) * (k - 1);
            pre = tmp;
        }
        return now;
    }
}
