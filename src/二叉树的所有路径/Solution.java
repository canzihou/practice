package 二叉树的所有路径;

import model.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    /*
     * @param root: the root of the binary tree
     * @return: all root-to-leaf paths
     */
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        generate(list, String.valueOf(root.val), root);
        return list;
    }

    private void generate(List<String> list, String path, TreeNode node) {
        if (node.left == null && node.right == null) {
            list.add(path);
        } else {
            if (node.left != null) {
                generate(list, path + "->" + node.left.val, node.left);
            }
            if (node.right != null) {
                generate(list, path + "->" + node.right.val, node.right);
            }
        }
    }
}
