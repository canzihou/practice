package N皇后问题;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    private String genStr(int n, int position) {
        char[] temp = new char[n];
        for (int i = 0; i < temp.length; i++) {
            temp[i] = '.';
        }
        temp[position - 1] = 'Q';
        return new String(temp);
    }

    private boolean check(int k, int[] nums) {
        for (int i = 1; i < k; i++) {
            if ((nums[i] == nums[k]) || Math.abs(nums[i] - nums[k]) == Math.abs(k - i)) {
                return false;
            }
        }
        return true;
    }

    public List<List<String>> solveNQueens(int n) {
        int[] temp = new int[n + 1];
        List<List<String>> result = new ArrayList<>();
        List<String> tempList = new ArrayList<>();
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
                    for (int i = 1; i < temp.length; i++) {
                        tempList.add(genStr(n, temp[i]));
                    }
                    result.add(new ArrayList<>(tempList));
                    tempList.clear();
                }
                k--;
                temp[k]++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<String>> lists = solution.solveNQueens(4);
        for (List<String> list : lists) {
            for (String s : list) {
                System.out.println(s);
            }
            System.out.println("///");
        }
    }
}

