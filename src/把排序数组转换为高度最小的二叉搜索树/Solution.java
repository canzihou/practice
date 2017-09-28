package 把排序数组转换为高度最小的二叉搜索树;

import model.TreeNode;

public class Solution {

    /*
     * @param A: an integer array
     * @return: A tree node
     */
    public TreeNode sortedArrayToBST(int[] A) {
        return buildTree(A, 0, A.length - 1);
    }

    private TreeNode buildTree(int[] A, int start, int end) {
        if (end < start) {
            return null;
        }
        if (start == end) {
            return new TreeNode(A[start]);
        }
        int mid = (end - start) / 2 + start;
        TreeNode root = new TreeNode(A[mid]);
        root.left = buildTree(A, start, mid - 1);
        root.right = buildTree(A, mid + 1, end);
        return root;
    }

    public static void main(String[] args) {
        int[] test = {1, 0, -1, 3};
        new Solution().sortedArrayToBST(test);
    }


}
