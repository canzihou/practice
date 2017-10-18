package 二叉树的序列化和反序列化;

import model.TreeNode;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    /**
     * This method will be invoked first, you should design your own algorithm
     * to serialize a binary tree which denote by a root node to a string which
     * can be easily deserialized by your own "deserialize" method later.
     */
    public String serialize(TreeNode root) {
        StringBuilder result = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode currNode = queue.poll();
            if (currNode == null) {
                result.append(",#");
            } else {
                result.append(",").append(currNode.val);
                queue.offer(currNode.left);
                queue.offer(currNode.right);
            }
        }
        return result.substring(1);
    }

    /**
     * This method will be invoked second, the argument data is what exactly
     * you serialized at method "serialize", that means the data is not given by
     * system, it's given by your own serialize method. So the format of data is
     * designed by yourself, and deserialize it here as you serialize it in
     * "serialize" method.
     */
    public TreeNode deserialize(String data) {
        if (data.equals("#")) {
            return null;
        }
        String[] tree = data.split(",");
        Queue<String> queue = new LinkedList<>();
        for (String node : tree) {
            queue.offer(node);
        }
        int rootval = Integer.parseInt(queue.poll());
        TreeNode root = new TreeNode(rootval);
        Queue<TreeNode> resultQueue = new LinkedList<>();
        resultQueue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode currNode = resultQueue.poll();
            String left = queue.poll();
            if (!left.equals("#")) {
                currNode.left = new TreeNode(Integer.parseInt(left));
                resultQueue.offer(currNode.left);
            }
            String right = queue.poll();
            if (!right.equals("#")) {
                currNode.right = new TreeNode(Integer.parseInt(right));
                resultQueue.offer(currNode.right);
            }
        }
        return root;
    }
}
