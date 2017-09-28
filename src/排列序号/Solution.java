package 排列序号;

public class Solution {
    /*
     * @param A: An array of integers
     * @return: A long integer
     */
    public long permutationIndex(int[] A) {
        return cal(A, 1L);
    }

    private long cal(int[] A, long total) {
        if (A.length == 1) {
            return total;
        } else if (A.length == 2) {
            return total + findPos(A) - 1;
        } else {
            int[] newA = new int[A.length - 1];
            System.arraycopy(A, 1, newA, 0, A.length - 1);
            total += (findPos(A) - 1) * calC(A.length - 1);
            return cal(newA, total);
        }
    }

    private long calC(long total) {
        long result = 1;
        while (total > 0) {
            result *= total--;
        }
        return result;
    }

    private int findPos(int[] A) {
        int first = A[0];
        int pos = 1;
        for (int i = 1; i < A.length; i++) {
            if (A[i] < first) {
                pos++;
            }
        }
        return pos;
    }

    public static void main(String[] args) {
        int[] ints = {2, 1, 9, 4, 3};
        System.out.println(new Solution().permutationIndex(ints));
    }
}
