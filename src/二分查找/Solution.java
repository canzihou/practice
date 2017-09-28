package 二分查找;

public class Solution {
    public int binarySearch(int[] nums, int target) {
        int head = 0;
        int tail = nums.length - 1;
        int mid = (head + tail) / 2;
        while (head < tail) {
            if (nums[mid] > target) {
                tail = mid - 1;
                mid = (head + tail) / 2;
            } else if (nums[mid] < target) {
                head = mid + 1;
                mid = (head + tail) / 2;
            } else {
                while (mid > head && nums[mid] == nums[mid - 1]) {
                    mid--;
                }
                return mid;
            }
        }
        return nums[mid] == target ? mid : -1;
    }

    public static void main(String[] args) {
        int[] nums = {1, 4, 4, 5, 7, 7, 8, 9, 9, 10};
        new Solution().binarySearch(nums, 1);
    }
}
