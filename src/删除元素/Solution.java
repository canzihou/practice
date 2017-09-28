package 删除元素;

public class Solution {
    /*
     * @param A: A list of integers
     * @param elem: An integer
     * @return: The new length after remove
     */
    public int removeElement(int[] A, int elem) {
        if (A.length == 0) {
            return 0;
        }
        int head = 0;
        int tail = A.length - 1;
        while (head < tail) {
            if (A[head] != elem) {
                head++;
                continue;
            }
            if (A[tail] == elem) {
                tail--;
                continue;
            }
            int temp = A[head];
            A[head++] = A[tail];
            A[tail--] = temp;
        }
        int[] result = new int[head + 1];
        System.arraycopy(A, 0, result, 0, head + 1);
        A = result;
        return head + 1;
    }

    public static void main(String[] args) {
        int[] A = {0, 4, 4, 0, 0, 2, 4, 4};
        new Solution().removeElement(A, 4);
    }
}
