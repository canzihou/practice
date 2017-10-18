package 安排课程;

import java.util.*;

/**
 * 你需要去上n门九章的课才能获得offer，这些课被标号为 0 到 n-1 。
 * 有一些课程需要“前置课程”，比如如果你要上课程0，你需要先学课程1，我们用一个匹配来表示他们： [0,1]
 * 给你课程的总数量和一些前置课程的需求，返回你为了学完所有课程所安排的学习顺序。
 * 可能会有多个正确的顺序，你只要返回一种就可以了。如果不可能完成所有课程，返回一个空数组。
 */
public class Solution {

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] pointedAt = new int[numCourses];
        Map<Integer, List<Integer>> pointing = new HashMap<>();
        for (int[] prerequisite : prerequisites) {
            pointedAt[prerequisite[0]]++;
            pointing.computeIfAbsent(prerequisite[1], k -> new ArrayList<>());
            pointing.get(prerequisite[1]).add(prerequisite[0]);
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < pointedAt.length; i++) {
            if (pointedAt[i] == 0) {
                queue.offer(i);
            }
        }
        int n = 0;
        int[] result = new int[numCourses];
        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            result[n++] = poll;
            List<Integer> list = pointing.get(poll);
            if (list != null) {
                for (Integer integer : list) {
                    pointedAt[integer]--;
                    if (pointedAt[integer] == 0) {
                        queue.offer(integer);
                    }
                }
            }
        }
        if (n == numCourses) {
            return result;
        } else {
            return new int[0];
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] test = {{5, 8}, {3, 5}, {1, 9}, {4, 5}, {0, 2}, {1, 9}, {7, 8}, {4, 9}};
        solution.findOrder(10, test);
    }
}
