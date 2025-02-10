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

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 最长有效括号
 *
 * @author lzb
 * @date 2024-06-10 21:06:19
 */
public class P32_LongestValidParentheses {


    public static void main(String[] args) {
        Solution solution = new P32_LongestValidParentheses().new Solution();
        System.out.println(solution.getPrimeNumber(100));

    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> getPrimeNumber(int range) {
            int[] a = new int[range];
            for (int i = 0; i < a.length - 1; i++) {
                a[i] = i + 2;
            }
            // prime number is 0 , composite number is 0
            // 素数为本身，合数为0
            for (int i = 2; i <= a.length; i++) {
                for (int j = 0; j < a.length - 1; j++) {
                    if (a[j] != 0 && (a[j] % i == 0 && a[j] / i != 1)) {
                        a[j] = 0;
                    }
                }
            }
            return Arrays.stream(a).filter(num -> num != 0).boxed().collect(Collectors.toList());
        }

        public int longestValidParentheses(String s) {
            int result = 0;
            int n = s.length();
            int[] dp = new int[n];
            for (int i = 1; i < n; ++i) {
                if (s.charAt(i) == ')') {
                    if (s.charAt(i - 1) == '(') {
                        dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                    } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                        dp[i] = (i - dp[i - 1] - 2 > 0 ? dp[i - dp[i - 1] - 2] : 0) + dp[i - 1] + 2;
                    }
                }
                result = Math.max(result, dp[i]);
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}
