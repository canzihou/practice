package 交叉字符串;

public class Solution {
    /*
     * @param s1: A string
     * @param s2: A string
     * @param s3: A string
     * @return: Determine whether s3 is formed by interleaving of s1 and s2
     */
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() == 0) {
            return s3.equals(s2);
        }
        if (s2.length() == 0) {
            return s3.equals(s1);
        }
        if (s3.charAt(0) != s2.charAt(0) && s3.charAt(0) != s1.charAt(0)) {
            return false;
        }
        if(s1.charAt(0) == s2.charAt(0)){
            return isInterleave(s1, s2.substring(1), s3.substring(1)) || isInterleave(s1.substring(1), s2, s3.substring(1));
        }
        if (s3.charAt(0) == s2.charAt(0)) {
            return isInterleave(s1, s2.substring(1), s3.substring(1));
        }
        return isInterleave(s1.substring(1), s2, s3.substring(1));
    }
}
