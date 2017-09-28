package 将二叉树拆成链表;

import model.TreeNode;

public class Solution {
    /*
     * @param root: a TreeNode, the root of the binary tree
     * @return:
     */
    public void flatten(TreeNode root) {
        if (root != null) {
            sort(root);
        }
    }

    private void sort(TreeNode root) {
        if (root.right != null) {
            sort(root.right);
        }
        if (root.left != null) {
            sort(root.left);
            TreeNode last = root.left;
            while (last.right != null) {
                last = last.right;
            }
            last.right = root.right;
            root.right = root.left;
        }
        root.left = null;
    }

    public static void main(String[] args) {
        TreeNode one = new TreeNode(1);
        one.right = new TreeNode(2);
        new Solution().flatten(one);
    }
}
