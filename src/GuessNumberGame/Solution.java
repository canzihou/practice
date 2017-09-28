package GuessNumberGame;

import java.util.Date;

public class Solution extends GuessGame {

    public static void main(String[] args) {
        long start = new Date().getTime();
        new Solution().guessNumber(10);
        long end = new Date().getTime();

        System.out.println(end);
        System.out.println(start);
        System.out.println(end - start);
    }

    public int guessNumber(int n) {
        int cur;
        int head = 1, tail = n;
        int guess;
        while (tail > head) {
            cur = head + (tail - head) / 2;
            guess = guess(cur);
            switch (guess) {
                case -1:
                    tail = cur - 1;
                    break;
                case 1:
                    head = cur + 1;
                    break;
                case 0:
                    return cur;
                default:
                    break;
            }
        }
        return head;
    }
}
