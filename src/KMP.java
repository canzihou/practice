public class KMP {

    private void makeNext(String p, int[] next) {
        int q, k;
        next[0] = 0;
        for (q = 1, k = 0; q < p.length(); q++) {
            while (k > 0 && p.charAt(q) != p.charAt(k)) {
                k = next[k - 1];
            }
            if (p.charAt(q) == p.charAt(k)) {
                k++;
            }
            next[q] = k;
        }
    }
}
