package 最小差;

import java.util.Arrays;

public class Solution {

    public int smallestDifference(int[] A, int[] B) {
        Arrays.sort(B);
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < A.length; i++) {
            int low = 0, high = B.length - 1, target = A[i], mid = 0;
            while (low <= high) {
                mid = low + (high - low) / 2;
                if (B[mid] == target) {
                    return 0;
                } else if (B[mid] < target) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
            result = Math.min(result, Math.abs(A[i] - B[mid]));
            if (mid > 0) {
                result = Math.min(result, Math.abs(A[i] - B[mid - 1]));
            }
            if (mid < B.length - 1) {
                result = Math.min(result, Math.abs(A[i] - B[mid + 1]));
            }
        }
        return result;
    }
}
