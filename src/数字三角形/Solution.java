package 数字三角形;

public class Solution {
    public int minimumTotal(int[][] triangle) {
        int[] hash = new int[triangle.length];
        if (triangle.length == 0) {
            return 0;
        }
        hash[0] = triangle[0][0];
        for (int i = 1; i < triangle.length; i++) {
            for (int j = triangle[i].length - 1; j > -1; j++) {
                int lo = Math.max(0, j - 1);
                int hi = Math.min(j, i - 1);
                hash[j] = triangle[i][j] + Math.min(hash[lo], hash[hi]);
            }
        }
        int result = hash[0];
        for (int i : hash) {
            if(i<result){
                result = i;
            }
        }
        return result;
    }
}
