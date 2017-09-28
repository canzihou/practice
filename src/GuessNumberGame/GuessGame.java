package GuessNumberGame;

public class GuessGame {

    int target = 4;

    int guess(int num) {
        if (num == target) {
            return 0;
        } else if (num > target) {
            return 1;
        } else {
            return -1;
        }
    }
}
