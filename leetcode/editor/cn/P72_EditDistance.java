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
        /**
         * 计算两个单词之间的编辑距离
         * @param word1 第一个单词
         * @param word2 第二个单词
         * @return 将word1转换为word2所需的最少操作次数
         */
        public int minDistance(String word1, String word2) {
            int len1 = word1.length(), len2 = word2.length();
            int[][] dp = new int[len1 + 1][len2 + 1];

            // 初始化边界条件：当其中一个字符串为空时
            for (int i = 0; i <= len1; i++) {
                dp[i][0] = i; // word1前i个字符转换为空串需要i次删除
            }
            for (int j = 0; j <= len2; j++) {
                dp[0][j] = j; // 空串转换为word2前j个字符需要j次插入
            }

            for (int i = 1; i <= len1; i++) {
                for (int j = 1; j <= len2; j++) {
                    if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                        // 字符相同，无需操作
                        dp[i][j] = dp[i - 1][j - 1];
                    } else {
                        // 取三种操作中的最小值并加1（替换操作）
                        dp[i][j] = Math.min(
                                dp[i - 1][j - 1], // 替换
                                Math.min(dp[i - 1][j], // 删除
                                        dp[i][j - 1]  // 插入
                                )
                        ) + 1;
                    }
                }
            }
            return dp[len1][len2];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
