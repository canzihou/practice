package 带重复元素的排列;

import java.util.*;

/**
 * 给出一个具有重复数字的列表，找出列表所有不同的排列。
 * <p>
 * 挑战
 * 使用递归和非递归分别完成该题。
 */
public class Solution {
//    /*
//     * @param :  A list of integers
//     * @return: A list of unique permutations
//     */
//    public List<List<Integer>> permuteUnique(int[] nums) {
//        List<List<Integer>> result = new ArrayList<>();
//        List<Integer> temp = new ArrayList<>();
//        for (int num : nums) {
//            temp.add(num);
//        }
//        Collections.sort(temp);
//        result.add(new ArrayList<>(temp));
//        while (genNext(temp, result)) {
//        }
//        return result;
//    }
//
//    /**
//     * 非递归方法，已通过
//     * 思路为按照字典序从最小开始慢慢生成下一个，直到产生最大序列为止
//     *
//     * @param temp
//     * @param result
//     * @return
//     */
//    private boolean genNext(List<Integer> temp, List<List<Integer>> result) {
//        //从后开始查找第一个正序对（因为是从最小生成到最大，查看哪里需要移动）
//        for (int i = temp.size() - 1; i > 0; i--) {
//            if (temp.get(i) > temp.get(i - 1)) {
//                //查找到后，将对中前面的数也就是小的数移动到后面，将它后面比它大的最小的数放到此位置
//                for (int j = temp.size() - 1; j > i - 1; j--) {
//                    if (temp.get(j) > temp.get(i - 1)) {
//                        int swap = temp.get(j);
//                        temp.set(j, temp.get(i - 1));
//                        temp.set(i - 1, swap);
//                        //此时那个正序对的后面那个数字开始后面的数字仍然是一个倒序排列，翻转成正序排列
//                        for (int k = temp.size() - 1, l = i; k > l; k--, l++) {
//                            swap = temp.get(k);
//                            temp.set(k, temp.get(l));
//                            temp.set(l, swap);
//                        }
//                        result.add(new ArrayList<>(temp));
//                        return true;
//                    }
//                }
//                return true;
//            }
//        }
//        return false;
//    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length == 0) {
            result.add(new ArrayList<Integer>());
            return result;
        }
        List<Integer> temp = new ArrayList<>();
        for (int num : nums) {
            temp.add(num);
        }
        Collections.sort(temp);
        handle(temp, result, 0);
        return result;
    }

    /**
     * 递归做法，已通过
     *
     * @param temp
     * @param result
     */
    private void handle(List<Integer> temp, List<List<Integer>> result, int head) {
        if (head == temp.size() - 1) {
            result.add(new ArrayList<>(temp));
        } else {
            //统计元素是否已经使用过
            Map<Integer, Boolean> hash = new HashMap<>();
            for (int i = head; i < temp.size(); i++) {
                if (hash.get(temp.get(i)) != null && hash.get(temp.get(i))) {
                    continue;
                }
                //让每个元素当一次头，然后排列后面的n-1个元素
                int swap = temp.get(i);
                temp.set(i, temp.get(head));
                temp.set(head, swap);
                handle(temp, result, head + 1);
                swap = temp.get(i);
                temp.set(i, temp.get(head));
                temp.set(head, swap);
                hash.put(temp.get(i), true);
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] test = {1, 2, 3};
        List<List<Integer>> permute = solution.permute(test);
        System.out.println(permute);
    }
}
