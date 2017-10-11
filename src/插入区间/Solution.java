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
        if (intervals.size() == 0) {
            intervals.add(newInterval);
            return intervals;
        }
        int index = 0;
        while (index < intervals.size()) {
            Interval interval1 = intervals.get(index);
            if (isNotCrossed(interval1, newInterval)) {
                if (newInterval.end < interval1.start) {
                    intervals.add(index, newInterval);
                    return intervals;
                } else {
                    index++;
                    if (index >= intervals.size()) {
                        intervals.add(newInterval);
                        return intervals;
                    }
                }
            } else {
                newInterval = new Interval(Math.min(interval1.start, newInterval.start), Math.max(interval1.end, newInterval.end));
                intervals.remove(index);
            }
        }
        intervals.add(newInterval);

        return intervals;
    }

    private boolean isNotCrossed(Interval a, Interval b) {
        return a.end < b.start || a.start > b.end;
    }

    public static void main(String[] args) {
        new Solution().insert(new ArrayList<Interval>(), new Interval(5, 7));
    }
}
