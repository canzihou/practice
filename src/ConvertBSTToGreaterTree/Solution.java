package ConvertBSTToGreaterTree;

import model.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {
    /*
     * @param root: the root of binary tree
     * @return: the new root
     */
    public TreeNode convertBST(TreeNode root) {
        // write your code here
        Stack<TreeNode> stack = new Stack<>();
        if (root != null) {
            handle(root, stack);
        }
        List<TreeNode> list = new ArrayList<>();
        while (!stack.empty()) {
            list.add(stack.pop());
        }
        for (int i = 0; i < list.size(); i++) {
            TreeNode treeNode = list.get(i);
            for (int j = i + 1; j < list.size(); j++) {
                treeNode.val += list.get(j).val;
            }
        }
        return root;
    }

    private void handle(TreeNode root, Stack<TreeNode> stack) {
        if (root.right != null) {
            handle(root.right, stack);
        }
        stack.push(root);
        if (root.left != null) {
            handle(root.left, stack);
        }
    }
}
