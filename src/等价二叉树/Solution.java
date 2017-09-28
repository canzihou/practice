package 等价二叉树;

import model.TreeNode;

public class Solution {
    /*
     * @param a: the root of binary tree a.
     * @param b: the root of binary tree b.
     * @return: true if they are identical, or false.
     */
    public boolean isIdentical(TreeNode a, TreeNode b) {
        return (a == null && b == null) || ((a != null && b != null) && (a.val == b.val && isIdentical(a.left, b.left) && isIdentical(a.right, b.right)));
    }

    private boolean equals(TreeNode a, TreeNode b) {
        return (a == null && b == null) || ((a != null && b != null) && (a.val == b.val && equals(a.left, b.left) && equals(a.right, b.right)));
    }
}
