//package 两数组的交II;
//
//import java.util.*;
//
//public class Solution {
//    public int[] intersection(int[] nums1, int[] nums2) {
//        Map<Integer, Integer> count = new HashMap<>();
//        List<Integer> result = new ArrayList<>();
//        for (int i : nums1) {
//            count.merge(i, 1, (a, b) -> a + b);
//        }
//        for (int i : nums2) {
//            if (count.get(i) != null && count.get(i) > 0) {
//                result.add(i);
//                count.put(i, count.get(i) - 1);
//            }
//        }
//        int[] resultArray = new int[result.size()];
//        for (int i = 0; i < result.size(); i++) {
//            resultArray[i] = result.get(i);
//        }
//        return resultArray;
//    }
//
//    public static void main(String[] args) {
//        int[] nums1 = {1, 2, 2, 1};
//        int[] nums2 = {2, 2};
//        int[] intersection = new Solution().intersection(nums1, nums2);
//        System.out.println(Arrays.toString(intersection));
//    }
//}
