package 子数组之和;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> subarraySum(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0, k = j + i; k < nums.length; j++, k++) {
                int total = 0;
                for (int l = j; l <=k ; l++) {
                    total += nums[l];
                    if (total == 0) {
                        list.add(j);
                        list.add(k);
                        return list;
                    }
                }
            }
        }
        return null;
    }
}
