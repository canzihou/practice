package 余弦相似度;

public class Solution {
    public double cosineSimilarity(int[] A, int[] B) {
        int aBot = 0;
        for (int i : A) {
            aBot += i * i;
        }
        int bBot = 0;
        for (int i : B) {
            bBot += i * i;
        }
        if (bBot == 0 || aBot == 0) {
            return 2d;
        }
        double aSqrt = Math.sqrt((double) aBot);
        double bSqrt = Math.sqrt((double) bBot);
        int top = 0;
        for (int i = 0; i < A.length; i++) {
            top += A[i] * B[i];
        }
        return top / (aSqrt * bSqrt);
    }
}
