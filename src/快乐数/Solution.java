package 快乐数;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    /*
     * @param n: An integer
     * @return: true if this is a happy number or false
     */
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        set.add(n);
        String s = String.valueOf(n);
        while (true) {
            n = 0;
            char[] chars = s.toCharArray();
            for (char aChar : chars) {
                n += (aChar - 48) * (aChar - 48);
            }
            if (n == 1) {
                return true;
            }
            if (set.contains(n)) {
                return false;
            }
            set.add(n);
            s = String.valueOf(n);
        }
    }

    public static void main(String[] args) {
        new Solution().isHappy(7);
    }
}
