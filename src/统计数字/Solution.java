package 统计数字;

public class Solution {
    public int digitCounts(int k, int n) {
        int count = 0;
        while (n >= 0) {
            int temp = n;
            if (temp % 10 == k) {
                count++;
            }
            while (temp >= 10) {
                temp /= 10;
                if (temp % 10 == k) {
                    count++;
                }
            }
            n--;
        }
        return count;
    }
}
