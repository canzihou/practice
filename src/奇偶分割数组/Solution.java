package 奇偶分割数组;

public class Solution {
    /*
     * @param nums: an array of integers
     * @return: nothing
     */
    public void partitionArray(int[] nums) {
        if (nums == null) {
            return;
        }
        int temp;
        for (int i = 0, j = nums.length - 1; i <= j; ) {
            if (nums[i] % 2 == 1) {
                i++;
                continue;
            }
            if (nums[j] % 2 == 0) {
                j--;
                continue;
            }
            temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
}
