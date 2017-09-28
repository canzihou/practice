package 合并区间;

import model.Interval;

import java.util.*;

public class Solution {
    /*
     * @param intervals: interval list.
     * @return: A new interval list.
     */
    public List<Interval> merge(List<Interval> intervals) {
        intervals.sort(Comparator.comparingInt(o -> o.start));
        for (int i = 0; i < intervals.size() - 1; i++) {
            if (intervals.get(i).end >= intervals.get(i + 1).start) {
                intervals.get(i + 1).start = intervals.get(i).start;
                if (intervals.get(i).end > intervals.get(i + 1).end) {
                    intervals.get(i + 1).end = intervals.get(i).end;
                }
                intervals.remove(i--);
            }
        }
        return intervals;
    }

}
