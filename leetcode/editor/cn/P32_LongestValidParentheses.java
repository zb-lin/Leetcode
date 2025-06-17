//给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。 
//
// 
//
// 
// 
// 示例 1： 
// 
// 
//
// 
//输入：s = "(()"
//输出：2
//解释：最长有效括号子串是 "()"
// 
//
// 示例 2： 
//
// 
//输入：s = ")()())"
//输出：4
//解释：最长有效括号子串是 "()()"
// 
//
// 示例 3： 
//
// 
//输入：s = ""
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 3 * 10⁴ 
// s[i] 为 '(' 或 ')' 
// 
//
// Related Topics 栈 字符串 动态规划 👍 2515 👎 0


package leetcode.editor.cn;

/**
 * 最长有效括号
 *
 * @author lzb
 * @date 2024-06-10 21:06:19
 */
public class P32_LongestValidParentheses {


    public static void main(String[] args) {
        Solution solution = new P32_LongestValidParentheses().new Solution();
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int longestValidParentheses(String s) {
            int n = s.length(), max = 0;
            int[] dp = new int[n];
            for (int i = 0; i < n; i++) {
                char ch = s.charAt(i);
                if (ch == '(') continue;
                if (i - 1 >= 0) {
                    if (s.charAt(i - 1) == '(') {
                        dp[i] = (i - 2 >= 0 && s.charAt(i - 2) == ')' ? dp[i - 2] : 0) + 2;
                    } else {
                        if (i - dp[i - 1] - 1 < 0) continue;
                        if (s.charAt(i - dp[i - 1] - 1) == '(') {
                            if (i - dp[i - 1] - 2 >= 0 && s.charAt(i - dp[i - 1] - 2) == ')') {
                                dp[i] = dp[i - 1] + dp[i - dp[i - 1] - 2] + 2;
                            } else {
                                dp[i] = dp[i - 1] + 2;
                            }
                        }
                    }
                }
                max = Math.max(max, dp[i]);
            }
            return max;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}
