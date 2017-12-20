package 子集;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 给定一个含不同整数的集合，返回其所有的子集
 * <p>
 * 注意事项
 * <p>
 * 子集中的元素排列必须是非降序的，解集必须不包含重复的子集
 * <p>
 * 样例
 * 如果 S = [1,2,3]，有如下的解：
 * <p>
 * [
 * [3],
 * [1],
 * [2],
 * [1,2,3],
 * [1,3],
 * [2,3],
 * [1,2],
 * []
 * ]
 * 挑战
 * 你可以同时用递归与非递归的方式解决么？
 */
public class Solution {

//    /*
//     * @param nums: A set of numbers
//     * @return: A list of lists
//     */
//    public List<List<Integer>> subsets(int[] nums) {
//        List<List<Integer>> result = new ArrayList<>();
//        ArrayList<Integer> accept = new ArrayList<>();
//        result.add(accept);
//        if (nums.length == 0) {
//            return result;
//        }
//        List<Integer> temp = new ArrayList<>();
//        for (int num : nums) {
//            temp.add(num);
//        }
//        Collections.sort(temp);
//        result.add(new ArrayList<>(temp));
//        for (int i = 1; i < nums.length; i++) {
//            handle(result, temp, accept, i, 0);
//        }
//        return result;
//    }
//
//    /**
//     * 递归做法，已通过
//     * @param result
//     * @param temp
//     * @param accept
//     * @param num
//     * @param cur
//     */
//    private void handle(List<List<Integer>> result, List<Integer> temp, List<Integer> accept, int num, int cur) {
//        if (num == 0) {
//            result.add(new ArrayList<>(accept));
//            return;
//        }
//        for (int i = cur; i < temp.size(); i++) {
//            Integer integer = temp.get(i);
//            accept.add(integer);
//            temp.remove(i);
//            handle(result, temp, accept, num - 1, i);
//            accept.remove(accept.size() - 1);
//            temp.add(i, integer);
//        }
//    }

    /**
     * 非递归做法，已通过
     *
     * @param nums: A set of numbers
     * @return A list of lists
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<List<Integer>> temp = new ArrayList<>();
        Arrays.sort(nums);
        result.add(new ArrayList<Integer>());
        for (int num : nums) {
            for (List<Integer> integers : result) {
                List<Integer> newList = new ArrayList<>(integers);
                newList.add(num);
                temp.add(newList);
            }
            result.addAll(temp);
            temp.clear();
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] test = {4, 1, 0};
        System.out.println(solution.subsets(test));
    }
}
