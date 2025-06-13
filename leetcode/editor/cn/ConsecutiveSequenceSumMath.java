package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * 给一个 S, 给出所有相加等于这个数S的连续递增数组, 比如 S= 15, [1 2 3 4 5] [4 5 6]
 */
public class ConsecutiveSequenceSumMath {
    public static void main(String[] args) {
        List<List<Integer>> result = consecutiveSequenceSumMath(15);
        System.out.println(result);
    }
    public static List<List<Integer>> consecutiveSequenceSumMath(int s) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 1; i <= s; ++i) {
            double n = Math.sqrt(i * i + 2 * s - i + 0.25) - 0.5;
            int intN = (int) n;
            if (n * n == intN * intN) {
                List<Integer> itemList = new ArrayList<>();
                for (int j = i; j <= n; ++j) {
                    itemList.add(j);
                }
                result.add(itemList);
            }
        }
        return result;
    }

}
