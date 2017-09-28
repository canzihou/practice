package 子树;

import model.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    /*
     * @param T1: The roots of binary tree T1.
     * @param T2: The roots of binary tree T2.
     * @return: True if T2 is a subtree of T1, or false.
     */
    public boolean isSubtree(TreeNode T1, TreeNode T2) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(T1);
        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            if (poll.val == T2.val) {
                boolean compare = compare(poll, T2);
                if (compare) {
                    return true;
                }
            }
            if (poll.left != null) {
                queue.add(poll.left);
            }
            if (poll.right != null) {
                queue.add(poll.right);
            }
        }
        return false;
    }

    private boolean compare(TreeNode T1, TreeNode T2) {
        return (T1 == null && T2 == null) || (T1 != null && T2 != null && T1.val == T2.val && compare(T1.left, T2.left) && compare(T1.right, T2.right));
    }
}
