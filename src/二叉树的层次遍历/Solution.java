package 二叉树的层次遍历;

import model.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    /*
     * @param root: A Tree
     * @return: Level order a list of lists of integer
     * 挑战一：使用一个队列实现
     */
//    public List<List<Integer>> levelOrder(TreeNode root) {
//        List<List<Integer>> lists = new ArrayList<>();
//        Queue<TreeNode> queue = new LinkedList<>();
//        if (root == null) {
//            return lists;
//        }
//        queue.add(root);
//        int level = 0;
//        while (!queue.isEmpty()) {
//            int size = queue.size();
//            while (size-- > 0) {
//                TreeNode poll = queue.poll();
//                if (poll != null) {
//                    if (lists.size() < level + 1) {
//                        lists.add(new ArrayList<>());
//                    }
//                    lists.get(level).add(poll.val);
//
//                    if (poll.left != null) {
//                        queue.add(poll.left);
//                    }
//                    if (poll.right != null) {
//                        queue.add(poll.right);
//                    }
//                }
//            }
//            level++;
//        }
//
//        return lists;
//    }

    /*
     * @param root: A Tree
     * @return: Level order a list of lists of integer
     * 挑战二：使用DFS实现
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
        if (root == null) {
            return lists;
        }
        dfs(lists, 0, root);
        return lists;
    }

    private void dfs(List<List<Integer>> lists, int level, TreeNode root) {
        if (lists.size() < level + 1) {
            lists.add(new ArrayList<>());
        }
        lists.get(level).add(root.val);
        if (root.left != null) {
            dfs(lists, level + 1, root.left);
        }
        if (root.right != null) {
            dfs(lists, level + 1, root.right);
        }
    }
}
