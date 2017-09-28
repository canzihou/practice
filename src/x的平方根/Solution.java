package x的平方根;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public int sqrt(int x) {
        int left = 1;
        int right = x;
        int mid = left + (right - left) / 2;
        while (left < right) {
            if (mid == x / mid) {
                return mid;
            }
            if (mid < x / mid) {
                left = mid + 1;
            }
            if (mid > x / mid) {
                right = mid - 1;
            }
            mid = left + (right - left) / 2;
        }
        if (mid > x / mid) {
            mid = mid - 1;
        }
        return mid;
    }

}
