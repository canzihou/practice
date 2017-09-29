package K个最近的点;

import model.Point;

import java.util.Arrays;

public class Solution {
    /*
     * @param points: a list of points
     * @param origin: a point
     * @param k: An integer
     * @return: the k closest points
     */
    public Point[] kClosest(Point[] points, Point origin, int k) {
        Point[] result = new Point[k];
        for (int i = 0; i < points.length - 1; i++) {
            for (int j = i + 1; j < points.length; j++) {
                if (!cmp(origin, points[i], points[j])) {
                    Point temp = points[i];
                    points[i] = points[j];
                    points[j] = temp;
                }
            }
        }
        System.arraycopy(points, 0, result, 0, k);
        return result;
    }

    private boolean cmp(Point origin, Point a, Point b) {
        int aLength = Math.abs(a.x - origin.x) * Math.abs(a.x - origin.x) + Math.abs(a.y - origin.y) * Math.abs(a.y - origin.y);
        int bLength = Math.abs(b.x - origin.x) * Math.abs(b.x - origin.x) + Math.abs(b.y - origin.y) * Math.abs(b.y - origin.y);
        if (aLength != bLength) {
            return aLength < bLength;
        } else if (a.x != b.x) {
            return a.x < b.x;
        } else {
            return a.y < b.y;
        }
    }
}
