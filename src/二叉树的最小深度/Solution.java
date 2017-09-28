package 二叉树的最小深度;

import model.TreeNode;

public class Solution {
    /*
     * @param root: The root of binary tree
     * @return: An integer
     */
    public int minDepth(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return 1;
        }
        return push(root, 1);
    }

    private int push(TreeNode root, int depth) {
        if (root.left == null && root.right == null) {
            return depth;
        }
        if (root.left == null) {
            return push(root.right, depth + 1);
        } else if (root.right == null) {
            return push(root.left, depth + 1);
        } else {
            return push(root.left, depth + 1) > push(root.right, depth + 1) ? push(root.right, depth + 1) : push(root.left, depth + 1);
        }
    }

}
