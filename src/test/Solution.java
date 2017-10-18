package test;


public class Solution {

    public static void main(String[] args) {
        int i = new Solution().noOfWays(16);
        System.out.println(i);
    }

    int noOfWays(int payAmount) {
        int[] s = new int[payAmount + 1];
        int temp = 2;
        s[0] = 1;
        s[1] = 1;
        for (int i = 2; i <= payAmount; i++) {
            int temp2 = temp * temp;
            s[i] = s[i - 1];
            while (i >= temp2) {
                if (i % temp2 == 0) {
                    s[i]++;
                }
                if (i > temp2 && temp2 > (i - temp2)) {
                    s[i] = s[i] + s[i - temp2] - 1;
                }
                temp++;
                temp2 = temp * temp;
            }
            temp = 2;
        }
        return s[payAmount];
    }
}
