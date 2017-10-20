package 线段树的构造;

import model.SegmentTreeNode;

public class Solution {

    /*
     * @param start: start value.
     * @param end: end value.
     * @return: The root of Segment Tree.
     */
    public SegmentTreeNode build(int start, int end) {
        if (start > end) {
            return null;
        }
        SegmentTreeNode segmentTreeNode = new SegmentTreeNode(start, end);
        build(start, end, segmentTreeNode);
        return segmentTreeNode;
    }

    private void build(int start, int end, SegmentTreeNode root) {
        if (start == end) {
            return;
        }
        SegmentTreeNode left = new SegmentTreeNode(start, start + (end - start) / 2);
        root.left = left;
        SegmentTreeNode right = new SegmentTreeNode(start + (end - start) / 2 + 1, end);
        root.right = right;
        build(start, start + (end - start) / 2, left);
        build(start + (end - start) / 2 + 1, end, right);
    }

}
