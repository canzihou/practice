package 比较字符串;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public boolean compareStrings(String A, String B) {
        char[] chars = A.toCharArray();
        char[] chars1 = B.toCharArray();
        if (chars.length == 0 && chars1.length != 0) {
            return false;
        }
        if (chars1.length == 0) {
            return true;
        }
        Map<Character, Integer> map = new HashMap<>();
        for (char aChar : chars) {
            map.merge(aChar, 1, (a, b) -> a + b);
        }

        for (char c : chars1) {
            if (map.get(c) == null || map.get(c) == 0) {
                return false;
            } else {
                map.put(c, map.get(c) - 1);
            }
        }
        return true;
    }

}
