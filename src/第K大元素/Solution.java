package 第K大元素;

public class Solution {
    public int kthLargestElement(int k, int[] nums) {
        return quicksort(k, nums, 0, nums.length - 1);
    }

    public int quicksort(int k, int[] nums, int low, int high) {
        int index = low;
        for (int i = low; i <= high; ++i) {
            if (nums[i] > nums[high]) {
                swap(nums, i, index++);
            }
        }
        swap(nums, high, index);
        if (k - 1 == index) {
            return nums[k - 1];
        } else if (k - 1 < index) {
            return quicksort(k, nums, low, index - 1);
        }
        return quicksort(k, nums, index + 1, high);
    }

    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
