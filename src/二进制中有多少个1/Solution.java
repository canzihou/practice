package 二进制中有多少个1;

public class Solution {
    /*
     * @param num: An integer
     * @return: An integer
     */
    public int countOnes(int num) {
        int count = 0;
        while (num != 0) {
            count++;
            num = num & num - 1;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(-1));
    }
}
