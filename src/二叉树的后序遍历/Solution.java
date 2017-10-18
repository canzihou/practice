package 二叉树的后序遍历;

import model.TreeNode;

import javax.jws.soap.SOAPBinding;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur;
        TreeNode pre = null;

        stack.push(root);
        while (!stack.isEmpty()) {
            cur = stack.peek();

            if (pre == null || pre.left == cur || pre.right == cur) {
                if (cur.left != null) {
                    stack.push(cur.left);
                } else if (cur.right != null) {
                    stack.push(cur.right);
                }
            } else if (cur.left == pre) {
                if (cur.right != null) {
                    stack.push(cur.right);
                }
            } else {
                res.add(cur.val);
                stack.pop();
            }
            pre = cur;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);

        solution.postorderTraversal(treeNode);
    }
}
