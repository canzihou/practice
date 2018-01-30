package 骰子求和;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 扔 n 个骰子，向上面的数字之和为 S。给定 Given n，请列出所有可能的 S 值及其相应的概率。
 */
public class Solution {

    /**
     * Ps. new AbstractMap.SimpleEntry<Integer, Double>(sum, pro)
     * to create the pair
     *
     * @param n an integer
     * @return a list of Map.Entry<sum, probability>
     */
    public List<Map.Entry<Integer, Double>> dicesSum(int n) {
        List<Map.Entry<Integer, Double>> list = new ArrayList<>();
        List<Map.Entry<Integer, Double>> temp = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            for (int j = i; j <= i * 6; j++) {
                Double per = 0d;
                if (i == 1) {
                    per += 1d / 6;
                } else {
                    for (int k = 1; k <= 6; k++) {
                        if (k >= j || k + 6 * (i - 1) < j) {
                            continue;
                        }
                        Double before = get(list, j - k);
                        per += 1d / 6 * (before == null ? 0 : before);
                    }
                }
                temp.add(new AbstractMap.SimpleEntry<>(j, per));
            }
            list.clear();
            list.addAll(temp);
            temp.clear();
        }
        return list;
    }

    private Double get(List<Map.Entry<Integer, Double>> list, Integer target) {
        for (Map.Entry<Integer, Double> entry : list) {
            if (entry.getKey().equals(target)) {
                return entry.getValue();
            }
        }
        return null;
    }

    public static void main(String[] args) {
        List<Map.Entry<Integer, Double>> entries = new Solution().dicesSum(3);
        for (Map.Entry<Integer, Double> entry : entries) {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }
    }
}
