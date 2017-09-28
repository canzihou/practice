package 合并排序数组;

public class Solution {
    /*
     * @param A: sorted integer array A
     * @param B: sorted integer array B
     * @return: A new sorted integer array
     */
    public int[] mergeSortedArray(int[] A, int[] B) {
        int a = 0;
        int b = 0;
        int index = 0;
        int[] result = new int[A.length + B.length];
        while (a < A.length && b < B.length) {
            if (A[a] < B[b]) {
                result[index++] = A[a++];
            } else if (A[a] > B[b]) {
                result[index++] = B[b++];
            } else {
                result[index++] = A[a++];
                result[index++] = B[b++];
            }
        }
        if (a < A.length) {
            System.arraycopy(A, a, result, index, A.length - a);
        }
        if (b < B.length) {
            System.arraycopy(B, b, result, index, B.length - b);
        }
        return result;
    }
}
