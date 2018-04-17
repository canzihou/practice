package 四位数吸血鬼数字;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        String[] targetNum = null;
        String[] gunNum = null;
        int sum = 0;
        int count = 0;
        for (int i = 10; i < 100; i++) {
            for (int j = i + 1; j < 100; j++) {
                int i_target = i * j;
                if (i_target < 1000 || i_target > 9999) {
                    continue;
                }
                count++;
                targetNum = String.valueOf(i_target).split("");
                gunNum = (String.valueOf(i) + String.valueOf(j)).split("");
                Arrays.sort(targetNum);
                Arrays.sort(gunNum);
                if (Arrays.equals(targetNum, gunNum)) {
                    sum++;
                    System.out.println("第" + sum + "个: " + i_target + "=" + i + "*" + j);
                }
            }
        }
        System.out.println("共进行了" + count + "次判断，找到" + sum + "个吸血鬼数字。");
    }
}
