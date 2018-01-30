package 数组划分;

public class Solution {
    /*
     * @param nums: The integer array you should partition
     * @param k: An integer
     * @return: The index after partition
     */
    public int partitionArray(int[] nums, int k) {
        int head = 0;
        int tail = nums.length - 1;
        while (head < tail) {
            while (head < tail && nums[head] < k) {
                head++;
            }
            while (head < tail && nums[tail] >= k) {
                tail--;
            }
            if (nums[head] > nums[tail]) {
                swap(nums, head, tail);
            }
        }
        return head == nums.length - 1 ? nums.length : Math.max(head, tail);
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
