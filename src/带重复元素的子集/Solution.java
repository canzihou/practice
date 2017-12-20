package 带重复元素的子集;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 给定一个可能具有重复数字的列表，返回其所有可能的子集
 * <p>
 * 注意事项
 * 子集中的每个元素都是非降序的
 * 两个子集间的顺序是无关紧要的
 * 解集中不能包含重复子集
 * 样例
 * 如果 S = [1,2,2]，一个可能的答案为：
 * <p>
 * [
 * [2],
 * [1],
 * [1,2,2],
 * [2,2],
 * [1,2],
 * []
 * ]
 * 挑战
 * 你可以同时用递归与非递归的方式解决么？
 */
public class Solution {
    private List<List<Integer>> result = new ArrayList<>();

    /*
     * @param nums: A set of numbers
     * @return: A list of lists
     */
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        if (nums.length == 0) {
            return result;
        }
        Arrays.sort(nums);
        List<Integer> temp = new ArrayList<>();
        handle(nums, 0, temp);
        return result;
    }

    /**
     * 递归做法，已通过
     */
    private void handle(int[] nums, int start, List<Integer> temp) {
        if (start == nums.length) {
            result.add(temp);
            return;
        }
        if (temp.size() == 0 || temp.get(temp.size() - 1) != nums[start]) {
            List<Integer> temp2 = new ArrayList<>(temp);
            handle(nums, start + 1, temp2);
        }
        temp.add(nums[start]);
        handle(nums, start + 1, temp);
    }

//    /**
//     * 非递归做法，已通过
//     *
//     * @param nums: A set of numbers
//     * @return A list of lists
//     */
//    public List<List<Integer>> subsetsWithDup(int[] nums) {
//        List<List<Integer>> result = new ArrayList<>();
//        List<List<Integer>> temp = new ArrayList<>();
//        Arrays.sort(nums);
//        result.add(new ArrayList<Integer>());
//        for (int i = 0; i < nums.length; i++) {
//            if (i > 0 && nums[i] == nums[i - 1]) {
//                for (List<Integer> integers : temp) {
//                    integers.add(nums[i]);
//                }
//            } else {
//                temp.clear();
//                for (List<Integer> integers : result) {
//                    List<Integer> newList = new ArrayList<>(integers);
//                    newList.add(nums[i]);
//                    temp.add(newList);
//                }
//
//            }
//            for (List<Integer> integers : temp) {
//                result.add(new ArrayList<>(integers));
//            }
//        }
//
//        return result;
//    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] test = {1, 2, 2, 2};
        System.out.println(solution.subsetsWithDup(test));
    }
}
