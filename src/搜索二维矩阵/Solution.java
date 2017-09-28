package 搜索二维矩阵;

public class Solution {
    /*
     * @param matrix: matrix, a list of lists of integers
     * @param target: An integer
     * @return: a boolean, indicate whether matrix contains target
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0) {
            return false;
        }
        int head = 0;
        int tail = matrix.length - 1;
        int mid = (head + tail) / 2;
        while (tail - head > 1) {
            if (matrix[mid][0] > target) {
                tail = mid;
                mid = (head + tail) / 2;
            } else if (matrix[mid][0] < target) {
                head = mid;
                mid = (head + tail) / 2;
            } else {
                return true;
            }
        }
        int head1 = 0;
        int tail1 = matrix[0].length - 1;
        int mid1 = (head1 + tail1) / 2;
        while (tail1 - head1 > 0) {
            if (matrix[head][mid1] > target) {
                tail1 = mid1 - 1;
                mid1 = (head1 + tail1) / 2;
            } else if (matrix[head][mid1] < target) {
                head1 = mid1 + 1;
                mid1 = (head1 + tail1) / 2;
            } else {
                return true;
            }
        }
        return matrix[head][head1] == target;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 8, 10, 16, 21, 23, 30, 31, 37, 39, 43, 44, 46, 53, 59, 66, 68, 71}, {90, 113, 125, 138, 157, 182, 207, 229, 242, 267, 289, 308, 331, 346, 370, 392, 415, 429, 440}, {460, 478, 494, 506, 527, 549, 561, 586, 609, 629, 649, 665, 683, 704, 729, 747, 763, 786, 796}, {808, 830, 844, 864, 889, 906, 928, 947, 962, 976, 998, 1016, 1037, 1058, 1080, 1093, 1111, 1136, 1157}, {1180, 1204, 1220, 1235, 1251, 1272, 1286, 1298, 1320, 1338, 1362, 1378, 1402, 1416, 1441, 1456, 1475, 1488, 1513}, {1533, 1548, 1563, 1586, 1609, 1634, 1656, 1667, 1681, 1706, 1731, 1746, 1760, 1778, 1794, 1815, 1830, 1846, 1861}};
        new Solution().searchMatrix(matrix, 1861);
    }
}
