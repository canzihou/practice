package 二叉查找树中搜索区间;

import model.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<Integer> searchRange(TreeNode root, int k1, int k2) {
        List<Integer> result = new ArrayList<>();
        search(root, result, k1, k2);
        return result;
    }

    private void search(TreeNode root, List<Integer> list, int k1, int k2) {
        if (root == null) {
            return;
        }
        if (root.val >= k1) {
            search(root.left, list, k1, k2);
        }
        if (root.val >= k1 && root.val <= k2) {
            list.add(root.val);
        }
        if (root.val <= k2) {
            search(root.right, list, k1, k2);
        }
    }
}
