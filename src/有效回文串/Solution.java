package 有效回文串;

public class Solution {
    /*
     * @param s: A string
     * @return: Whether the string is a valid palindrome
     */
    public boolean isPalindrome(String s) {
        if(s == null){
            return false;
        }
        if(s.equals("")){
            return true;
        }
        s = s.toLowerCase();
        char[] chars = s.toCharArray();
        for(int i = 0, j = chars.length - 1; j>=i;){
            if((chars[i] > '0' && chars[i] < '9') || (chars[i] > 'a' && chars[i] < 'z')){
                if((chars[j] > '0' && chars[j] < '9') || (chars[j] > 'a' && chars[j] < 'z')){
                    if(chars[i] != chars[j]){
                        return false;
                    } else {
                        i++;
                        j--;
                    }
                } else {
                    j--;
                }
            } else {
                i++;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        new Solution().isPalindrome("ab");
    }
}
