//给你两个单词 word1 和 word2， 请返回将 word1 转换成 word2 所使用的最少操作数 。 
//
// 你可以对一个单词进行如下三种操作： 
//
// 
// 插入一个字符 
// 删除一个字符 
// 替换一个字符 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：word1 = "horse", word2 = "ros"
//输出：3
//解释：
//horse -> rorse (将 'h' 替换为 'r')
//rorse -> rose (删除 'r')
//rose -> ros (删除 'e')
// 
//
// 示例 2： 
//
// 
//输入：word1 = "intention", word2 = "execution"
//输出：5
//解释：
//intention -> inention (删除 't')
//inention -> enention (将 'i' 替换为 'e')
//enention -> exention (将 'n' 替换为 'x')
//exention -> exection (将 'n' 替换为 'c')
//exection -> execution (插入 'u')
// 
//
// 
//
// 提示： 
//
// 
// 0 <= word1.length, word2.length <= 500 
// word1 和 word2 由小写英文字母组成 
// 
//
// Related Topics 字符串 动态规划 👍 3391 👎 0


package leetcode.editor.cn;

/**
 * 编辑距离
 *
 * @author lzb
 * @date 2024-05-22 13:49:42
 */
public class P72_EditDistance {
    public static void main(String[] args) {
        Solution solution = new P72_EditDistance().new Solution();
        solution.minDistance("horse", "ros");
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minDistance(String word1, String word2) {
            int m = word1.length(), n = word2.length();
            int[][] dp = new int[n + 1][m + 1];
            for (int i = 0; i <= n; ++i) {
                dp[i][0] = i;
            }
            for (int j = 0; j <= m; j++) {
                dp[0][j] = j;
            }
            for (int i = 1; i <= n; ++i) {
                for (int j = 1; j <= m; ++j) {
                    if (word1.charAt(j - 1) == word2.charAt(i - 1)) {
                        dp[i][j] = dp[i - 1][j - 1];
                    } else {
                        int up = dp[i - 1][j];
                        int left = dp[i][j - 1];
                        int leftUp = dp[i - 1][j - 1];
                        dp[i][j] = 1 + Math.min(up, Math.min(leftUp, left));
                    }
                }
            }
            return dp[n][m];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
