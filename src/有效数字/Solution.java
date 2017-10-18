package 有效数字;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {

    public boolean isNumber(String s) {
        if (s == null) {
            return false;
        }
        s = s.trim();
        Pattern pattern1 = Pattern.compile("\\d+");
        Pattern pattern2 = Pattern.compile("\\d+e\\d+");
        Pattern pattern3 = Pattern.compile("[+]?\\d*\\.\\d+");
        Pattern pattern4 = Pattern.compile("\\d+\\.\\d*");
        Matcher matcher1 = pattern1.matcher(s);
        Matcher matcher2 = pattern2.matcher(s);
        Matcher matcher3 = pattern3.matcher(s);
        Matcher matcher4 = pattern4.matcher(s);
        return matcher1.matches() || matcher2.matches() || matcher3.matches() || matcher4.matches();
    }

}
