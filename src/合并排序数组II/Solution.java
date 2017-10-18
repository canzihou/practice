package 合并排序数组II;

import java.util.Arrays;

public class Solution {

    public void mergeSortedArray(int[] A, int m, int[] B, int n) {
        int a = 0;
        int b = 0;
        while (a < m + b && b < n) {
            if (A[a] > B[b]) {
                System.arraycopy(A, a, A, a + 1, m + b - a);
                A[a] = B[b];
                a++;
                b++;
            } else {
                a++;
            }
        }
        if (b < n) {
            System.arraycopy(B, b, A, m + b, n - b);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] A = {1, 3, 4, 6, 0, 0};
        int[] B = {2, 5};

        solution.mergeSortedArray(A, 4, B, 2);
        System.out.println(Arrays.toString(A));
    }
}
