package 翻转二叉树;

import model.TreeNode;

import java.util.*;

public class Solution {
    /*
     * @param root: a TreeNode, the root of the binary tree
     * @return: nothing
     */
    public void invertBinaryTree(TreeNode root) {
        if (root == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            swap(poll);
            if (poll.left != null) {
                queue.add(poll.left);
            }
            if (poll.right != null) {
                queue.add(poll.right);
            }
        }
    }

    private void swap(TreeNode root) {
        TreeNode temp;
        temp = root.left;
        root.left = root.right;
        root.right = temp;
    }

}
