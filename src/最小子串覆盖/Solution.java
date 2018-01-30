package 最小子串覆盖;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    /*
     * @param source : A string
     * @param target: A string
     * @return: A string denote the minimum window, return "" if there is no such a string
     */
    public String minWindow(String source, String target) {
        Map<Character, Integer> targetHash = new HashMap<>();
        Map<Character, Integer> srcHash = new HashMap<>();
        for (int i = 0; i < target.length(); i++) {
            targetHash.merge(target.charAt(i), 1, (a, b) -> a + b);
        }
        int found = 0;
        int start = 0;
        int end = source.length();
        int minLength = source.length();
        int begin = -1;
        for (int i = 0; i < source.length(); i++) {
            srcHash.merge(source.charAt(i), 1, (a, b) -> a + b);
            if (targetHash.get(source.charAt(i)) != null
                    && srcHash.get(source.charAt(i)) <= targetHash.get(source.charAt(i))) {
                found++;
            }
            if (found == target.length()) {
                while (!targetHash.containsKey(source.charAt(start))
                        || srcHash.get(source.charAt(start)) > targetHash.get(source.charAt(start))) {
                    srcHash.put(source.charAt(start), srcHash.get(source.charAt(start)) - 1);
                    start++;
                }
                if(i - start < minLength){
                    minLength = i - start;
                    begin = start;
                    end = i;
                }
                srcHash.put(source.charAt(start), srcHash.get(source.charAt(start)) - 1);
                found--;
                start++;
            }
        }
        return begin == -1 ? "" : source.substring(begin,end + 1);
    }

    public static void main(String[] args) {
        new Solution().minWindow("abcdecf","acc");
    }
}
