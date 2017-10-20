package 线段树的查询;

import model.SegmentTreeNode;

public class Solution {
    public int query(SegmentTreeNode root, int start, int end) {
        if (root.start == start && root.end == end) {
            return root.max;
        }
        if (end <= (root.start + (root.end - root.start) / 2)) {
            return query(root.left, start, end);
        } else if (start >= (root.start + (root.end - root.start) / 2) + 1) {
            return query(root.right, start, end);
        } else {
            return Math.max(query(root.left, start, root.start + (root.end - root.start) / 2), query(root.right, root.start + (root.end - root.start) / 2 + 1, end));
        }
    }
}
