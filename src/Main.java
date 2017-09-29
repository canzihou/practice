import util.ArrayUtil;

import java.util.*;

/**
 * 测试类
 */
public class Main {

    /*
    *  123.206.115.18
    root
    XGwyf0513
    *
    * */

    public static void main(String[] args) {
        String strings = new Main().addStrings("19999999", "1");
        System.out.println(strings);
    }

    public static void revert(char[] array) {
        char temp;
        for (int i = 0, j = array.length - 1; j >= i; i++, j--) {
            temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
    }

    public String addStrings(String num1, String num2) {
        char[] result;
        if (num1.length() > num2.length()) {
            result = new char[num1.length() + 1];
        } else {
            result = new char[num2.length() + 1];
        }
        char[] array1 = num1.toCharArray();
        revert(array1);
        char[] array2 = num2.toCharArray();
        revert(array2);
        int plus = 0;
        for (int i = 0; i < num1.length() || i < num2.length(); i++) {
            int i1 = 0;
            if (i < num1.length()) {
                i1 += array1[i] - 48;
            }
            if (i < num2.length()) {
                i1 += array2[i] - 48;
            }
            i1 += plus;
            if (i1 < 10) {
                result[i] = (char) (i1 + 48);
                plus = 0;
            } else {
                result[i] = (char) (i1 - 10 + 48);
                plus = 1;
            }
        }
        revert(result);
        if (plus == 1) {
            result[0] = 49;
        }
        if (result[0] == 0) {
            char[] finalresult = new char[result.length - 1];
            System.arraycopy(result, 1, finalresult, 0, result.length - 1);
            result = finalresult;
        }
        return new String(result);
    }

    public List<Integer> findAnagrams(String s, String p) {
        ArrayList<Integer> result = new ArrayList<>();
        if (s == null || p == null) return result;
        int left = 0, right = 0, count = p.length();
        int[] map = new int[256];
        char[] sc = s.toCharArray();
        for (char c : p.toCharArray()) map[c]++;
        while (right < s.length()) {
            if (map[sc[right++]]-- >= 1) count--;
            if (count == 0) result.add(left);
            if (right - left == p.length() && map[sc[left++]]++ >= 0) count++;
        }
        return result;
    }

    public int firstUniqChar(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.merge(c, 1, (a, b) -> a + b);
        }
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.get(c) == 1) {
                return i;
            }
        }
        return -1;
    }

    public boolean isIsomorphic(String s, String t) {
        // Write your code here
        HashMap<Character, Character> record = new HashMap<>();
        HashSet<Character> repeat = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            char key = s.charAt(i);
            char value = t.charAt(i);
            if (!record.containsKey(key)) {
                if (repeat.contains(value)) {
                    return false;
                }
                record.put(key, value);
                repeat.add(value);
            } else {
                if (record.get(key) != value) {
                    return false;
                }
            }
        }
        return true;
    }

    public int[] intersection(int[] nums1, int[] nums2) {
        // write your code here
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for (int i : nums1) {
            set1.add(i);
        }
        for (int i : nums2) {
            if (set1.contains(i)) {
                set2.add(i);
            }
        }
        int[] result = new int[set2.size()];
        int index = 0;
        for (Integer integer : set2) {
            result[index] = integer;
        }
        return result;
    }

    public boolean isPalindrome(int num) {
        // write your code here
        char[] chars = Integer.toString(num).toCharArray();
        if (chars[chars.length - 1] == '0') {
            return false;
        }
        for (int i = 0, j = chars.length - 1; i <= j; i++, j--) {
            if (chars[i] != chars[j]) {
                return false;
            }
        }
        return true;
    }

    public String rotateString(char[] str, int offset) {
        // write your code here
        offset = offset % str.length;
        char[] temp = new char[str.length];
        for (int i = 0; i < str.length; i++) {
            temp[(i + offset) % str.length] = str[i];
        }
        System.arraycopy(temp, 0, str, 0, str.length);
        return new String(str);
    }

    public int countRotateWords(List<String> words) {
        if (words.size() == 0) {
            return 0;
        }
        Set<String> set = new HashSet<>();
        String s = words.get(0);
        int result = 1;
        for (int i = 0; i < s.length(); i++) {
            String s1 = rotateString(s.toCharArray(), i);
            set.add(s1);
        }
        for (int i = 1; i < words.size(); i++) {
            String s1 = words.get(i);
            if (!set.contains(s1)) {
                result++;
                for (int j = 0; j < s1.length(); j++) {
                    String s2 = rotateString(s1.toCharArray(), j);
                    set.add(s2);
                }
            }
        }
        return result;
    }

    public boolean Permutation(String A, String B) {
        // write your code here
        char[] aChar = A.toCharArray();
        char[] bChar = B.toCharArray();
        Arrays.sort(aChar);
        Arrays.sort(bChar);
        return Arrays.equals(aChar, bChar);
    }

    public int hashCode(char[] key, int HASH_SIZE) {
        // write your code here
        int value = 0;
        int coefficient = 1;

        for (int i = key.length - 1; i >= 0; i--) {
            value = (value + key[i] * coefficient) % HASH_SIZE;
            coefficient = coefficient * 33 % HASH_SIZE;
        }

        return value % HASH_SIZE;
    }

    /**
     * 动态规划题
     *
     * @param values
     * @return
     */
    public boolean firstWillWin(int[] values) {
        // write your code here
        // dp 表示从i到end 的最大值
//         int values[] ={1,2,4,3,4,8,5,6,12};
        int len = values.length;
        int[] dp = new int[len + 1];
        if (len <= 2) return true;
        dp[len] = 0;
        dp[len - 1] = values[len - 1];
        dp[len - 2] = values[len - 2] + values[len - 1];
        dp[len - 3] = values[len - 3] + values[len - 2];
        for (int i = len - 4; i >= 0; i--) {
            dp[i] = Math.max(values[i] + Math.min(dp[i + 2], dp[i + 3]), values[i] + values[i + 1] + Math.min(dp[i + 3], dp[i + 4]));
        }
        int sum = 0;
        for (int a : values) sum += a;
        return dp[0] > sum - dp[0];
    }

}
