package 中位数;

public class Solution {
    /*
     * @param nums: A list of integers
     * @return: An integer denotes the middle number of the array
     */
    public int median(int[] nums) {
        int head = 0;
        int tail = nums.length - 1;
        quickSort(nums, head, tail);
        return nums[nums.length / 2];
    }

    private int quickSort(int[] nums, int start, int end) {
        int pivot = nums[start];//取数组中第一个元素为枢纽
        int i = start;
        int j = end;
        if (start < end) {
            while (i < j) {
                while (i < end && nums[i] <= pivot) {
                    i++;
                }
                while (j > start && nums[j] >= pivot) {
                    j--;
                }

                if (i < j) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                } else {
                    break;
                }
            }

            if (pivot > nums[j]) {
                nums[start] = nums[j];
                nums[j] = pivot;
            }//这里的交换，需要先判断pivot和nums[j]的大小（因为枢纽元素是start位置，所以需要与j位置的进行判断并交换）

            //找到pivot存在的位置j，这里是j位置作为枢纽的存放位置，所以判断j与（N-1）/2的大小关系
            if (j == (nums.length - 1) / 2) {
                return nums[j];
            } else if (j < (nums.length - 1) / 2) {
                return quickSort(nums, j + 1, end);
            } else {
                return quickSort(nums, start, j - 1);
            }
        } else {
            return nums[start];
        }

    }
}
