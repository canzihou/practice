package 插入区间;

import model.Interval;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    /*
     * @param intervals: Sorted interval list.
     * @param newInterval: new interval.
     * @return: A new interval list.
     */
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        int end = intervals.size() > 0 ? intervals.get(intervals.size() - 1).end : 0;
        int[] hash = new int[Math.max(end, newInterval.end) + 1];
        for (Interval interval : intervals) {
            for (int j = interval.start; j < interval.end; j++) {
                hash[j] = 1;
            }
        }
        for (int i = newInterval.start; i < newInterval.end; i++) {
            hash[i] = 1;
        }
        intervals.clear();
        int head = 0;
        int tail = head + 1;
        while (head < hash.length && tail < hash.length) {
            while (hash[head] == 0) {
                head++;
            }
            if (head < hash.length) {
                tail = head + 1;
                while (tail < hash.length && hash[tail] == 1) {
                    tail++;
                }
                intervals.add(new Interval(head, tail));
                head = tail + 1;
            }
        }
        return intervals;
    }

    public static void main(String[] args) {
        new Solution().insert(new ArrayList<Interval>(), new Interval(5, 7));
    }
}
