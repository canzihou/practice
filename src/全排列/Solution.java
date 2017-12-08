package 全排列;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 给定一个数字列表，返回其所有可能的排列。
 * <p>
 * 样例
 * 给出一个列表[1,2,3]，其全排列为：
 * <p>
 * [
 * [1,2,3],
 * [1,3,2],
 * [2,1,3],
 * [2,3,1],
 * [3,1,2],
 * [3,2,1]
 * ]
 * <p>
 * 挑战
 * 使用递归和非递归分别解决。
 */
public class Solution {

    /*
     * @param nums: A list of integers.
     * @return: A list of permutations.
     */
//    public List<List<Integer>> permute(int[] nums) {
//        List<List<Integer>> result = new ArrayList<>();
//        if(nums.length==0){
//            result.add(new ArrayList<Integer>());
//            return result;
//        }
//        List<Integer> temp = new ArrayList<>();
//        List<Integer> remain = new ArrayList<>();
//        for (int num : nums) {
//            remain.add(num);
//        }
//        handle(temp, result, remain);
//        return result;
//    }
//
//    /**
//     * 递归做法，已通过
//     * @param temp
//     * @param result
//     * @param remain
//     */
//    private void handle(List<Integer> temp, List<List<Integer>> result, List<Integer> remain) {
//        if (remain.size() == 0) {
//            result.add(new ArrayList<>(temp));
//        } else {
//            for (int i = 0; i < remain.size(); i++) {
//                Integer integer = remain.get(0);
//                temp.add(integer);
//                remain.remove(integer);
//                handle(temp, result, remain);
//                temp.remove(temp.size()-1);
//                remain.add(integer);
//            }
//        }
//    }

    /*
     * @param nums: A list of integers.
     * @return: A list of permutations.
     */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        for (int num : nums) {
            temp.add(num);
        }
        Collections.sort(temp);
        result.add(new ArrayList<>(temp));
        while (genNext(temp, result)) {
        }
        return result;
    }

    /**
     * 非递归方法，已通过
     * 思路为按照字典序从最小开始慢慢生成下一个，直到产生最大序列为止
     * 本题中没有考虑重复元素问题
     *
     * @param temp
     * @param result
     * @return
     */
    private boolean genNext(List<Integer> temp, List<List<Integer>> result) {
        //从后开始查找第一个正序对（因为是从最小生成到最大，查看哪里需要移动）
        for (int i = temp.size() - 1; i > 0; i--) {
            if (temp.get(i) > temp.get(i - 1)) {
                //查找到后，将对中前面的数也就是小的数移动到后面，将它后面比它大的最小的数放到此位置
                for (int j = temp.size() - 1; j > i - 1; j--) {
                    if (temp.get(j) > temp.get(i - 1)) {
                        int swap = temp.get(j);
                        temp.set(j, temp.get(i - 1));
                        temp.set(i - 1, swap);
                        //此时那个正序对的后面那个数字开始后面的数字仍然是一个倒序排列，翻转成正序排列
                        for (int k = temp.size() - 1, l = i; k > l; k--, l++) {
                            swap = temp.get(k);
                            temp.set(k, temp.get(l));
                            temp.set(l, swap);
                        }
                        result.add(new ArrayList<>(temp));
                        return true;
                    }
                }
                return true;
            }
        }
        return false;
    }
}
