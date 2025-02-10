//给你一个由 n 个数对组成的数对数组 pairs ，其中 pairs[i] = [lefti, righti] 且 lefti < righti 。 
//
// 现在，我们定义一种 跟随 关系，当且仅当 b < c 时，数对 p2 = [c, d] 才可以跟在 p1 = [a, b] 后面。我们用这种形式来构造 数
//对链 。 
//
// 找出并返回能够形成的 最长数对链的长度 。 
//
// 你不需要用到所有的数对，你可以以任何顺序选择其中的一些数对来构造。 
//
// 
//
// 示例 1： 
//
// 
//输入：pairs = [[1,2], [2,3], [3,4]]
//输出：2
//解释：最长的数对链是 [1,2] -> [3,4] 。
// 
//
// 示例 2： 
//
// 
//输入：pairs = [[1,2],[7,8],[4,5]]
//输出：3
//解释：最长的数对链是 [1,2] -> [4,5] -> [7,8] 。 
//
// 
//
// 提示： 
//
// 
// n == pairs.length 
// 1 <= n <= 1000 
// -1000 <= lefti < righti <= 1000 
// 
//
// Related Topics 贪心 数组 动态规划 排序 👍 445 👎 0


package leetcode.editor.cn;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 最长数对链
 *
 * @author lzb
 * @date 2024-09-19 19:05:54
 */
public class P646_MaximumLengthOfPairChain {
    public static void main(String[] args) {
        Solution solution = new P646_MaximumLengthOfPairChain().new Solution();
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findLongestChain(int[][] pairs) {
            int n = pairs.length;
            Arrays.sort(pairs, Comparator.comparingInt(a -> a[0]));
            int[] dp = new int[n];
            Arrays.fill(dp, 1);
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < i; j++) {
                    if (pairs[j][1] < pairs[i][0]) {
                        dp[i] = Math.max(dp[i], dp[j] + 1);
                    }
                }
            }
            return dp[n - 1];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}
