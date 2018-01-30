package N皇后问题II;

public class Solution {
    private boolean check(int k, int[] nums) {
        for (int i = 1; i < k; i++) {
            if ((nums[i] == nums[k]) || Math.abs(nums[i] - nums[k]) == Math.abs(k - i)) {
                return false;
            }
        }
        return true;
    }

    public int solveNQueens(int n) {
        int count = 0;
        int[] temp = new int[n + 1];
        int k = 1;
        temp[k] = 1;
        while (k > 0) {
            if (k <= n && temp[k] <= n) {
                if (!check(k, temp)) {
                    temp[k]++;
                } else {
                    k++;
                    if (k <= n) {
                        temp[k] = 1;
                    }
                }
            } else {
                if (k > n) {
                    count++;
                }
                k--;
                temp[k]++;
            }
        }
        return count;
    }
}

