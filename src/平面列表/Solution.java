package 平面列表;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {

    interface NestedInteger {
        boolean isInteger();

        Integer getInteger();

        List<NestedInteger> getList();
    }

    // @param nestedList a list of NestedInteger
    // @return a list of integer
    public List<Integer> flatten(List<NestedInteger> nestedList) {
        List<Integer> list = new ArrayList<>();
        Stack<NestedInteger> stack = new Stack<>();

        for (int i = nestedList.size() - 1; i >= 0; i--) {
            stack.push(nestedList.get(i));
        }
        while (!stack.empty()) {
            NestedInteger nestedInteger = stack.pop();
            if (nestedInteger.isInteger()) {
                list.add(nestedInteger.getInteger());
            } else {
                List<NestedInteger> list1 = nestedInteger.getList();
                for (int i = list1.size() - 1; i >= 0; i--) {
                    stack.push(list1.get(i));
                }
            }
        }
        return list;
    }
}
