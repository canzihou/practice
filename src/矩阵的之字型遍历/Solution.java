package 矩阵的之字型遍历;

import java.util.Arrays;

public class Solution {
    /*
     * @param matrix: An array of integers
     * @return: An array of integers
     */
    public int[] printZMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return null;
        }
        if (matrix.length == 1) {
            return matrix[0];
        }
        if (matrix[0].length == 1) {
            int[] result = new int[matrix.length];
            for (int i = 0; i < matrix.length; i++) {
                result[i] = matrix[i][0];
            }
            return result;
        }
        int x = 0;
        int y = 1;
        int offsetX = 1;
        int offsetY = -1;

        int index = 2;
        int[] result = new int[matrix.length * matrix[0].length];
        result[0] = matrix[0][0];
        result[1] = matrix[0][1];
        while (index < result.length) {
            result[index++] = matrix[x + offsetX][y + offsetY];
            x = x + offsetX;
            y = y + offsetY;
            if (y == 0 && x != matrix.length - 1) {
                result[index++] = matrix[++x][y];
                offsetX = -1;
                offsetY = 1;
            } else if (x == matrix.length - 1 && index < result.length) {
                result[index++] = matrix[x][++y];
                offsetX = -1;
                offsetY = 1;
            } else if (y == matrix[0].length - 1 && index < result.length) {
                result[index++] = matrix[++x][y];
                offsetX = 1;
                offsetY = -1;
            } else if (x == 0 && y != matrix[0].length - 1) {
                result[index++] = matrix[x][++y];
                offsetX = 1;
                offsetY = -1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
    }
}
