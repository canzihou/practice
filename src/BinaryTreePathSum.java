import model.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePathSum {
    /**
     * lintcode 二叉树的路径和
     *
     * @param root
     * @param target
     * @return
     */
    public List<List<Integer>> binaryTreePathSum(TreeNode root, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if(null == root) return result;
        Stack<Integer> stack = new Stack<>();
        binaryTreePathSum(result, stack, root, 0, target);
        return result;
    }

    private void binaryTreePathSum(List<List<Integer>> result, Stack<Integer> stack, TreeNode root, int sum, int target) {
        sum += root.val;
        stack.push(root.val);
        if(sum == target && root.left == null && root.right == null) {
            List<Integer> list = new ArrayList<>(stack);
            result.add(list);
            stack.pop();
        }else {
            if(root.left != null)
                binaryTreePathSum(result, stack, root.left, sum, target);
            if(root.right != null)
                binaryTreePathSum(result, stack, root.right, sum, target);
            stack.pop();
        }
    }
}
