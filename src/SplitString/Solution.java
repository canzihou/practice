package SplitString;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    /*
     * @param : a string to be split
     * @return: all possible split string array
     */
    public List<List<String>> splitString(String s) {
        List<List<String>> lists = new ArrayList<>();
        if (s == null || s.equals("")) {
            lists.add(new ArrayList<>());
            return lists;
        }
        add(s, lists, new ArrayList<>());
        return lists;
    }

    private void add(String s, List<List<String>> lists, List<String> list) {
        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        list1.addAll(list);
        list2.addAll(list);
        if (s.length() == 0) {
            return;
        }
        if (s.length() == 1) {
            list1.add(s);
            lists.add(list1);
            return;
        }
        if (s.length() == 2) {
            list1.add(s);
            lists.add(list1);
            list2.add(s.substring(0, 1));
            list2.add(s.substring(1, 2));
            lists.add(list2);
            return;
        }
        list1.add(s.substring(0, 1));
        add(s.substring(1), lists, list1);
        list2.add(s.substring(0, 2));
        add(s.substring(2), lists, list2);
    }


}
