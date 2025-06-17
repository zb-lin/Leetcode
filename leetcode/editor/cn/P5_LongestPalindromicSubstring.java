//给你一个字符串 s，找到 s 中最长的 回文 子串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "babad"
//输出："bab"
//解释："aba" 同样是符合题意的答案。
// 
//
// 示例 2： 
//
// 
//输入：s = "cbbd"
//输出："bb"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 仅由数字和英文字母组成 
// 
//
// Related Topics 双指针 字符串 动态规划 👍 7241 👎 0


package leetcode.editor.cn;

/**
 * 最长回文子串
 *
 * @author lzb
 * @date 2024-06-10 20:16:06
 */
public class P5_LongestPalindromicSubstring {
    public static void main(String[] args) {
        Solution solution = new P5_LongestPalindromicSubstring().new Solution();
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 寻找字符串中的最长回文子串
         * @param s 输入字符串
         * @return 最长回文子串
         */
        public String longestPalindrome(String s) {
            int left = 0, right = 0, maxLen = 0;
            for (int i = 0; i < s.length() - 1; ++i) {
                int[] r1 = expand(s, i, i);
                int[] r2 = expand(s, i, i + 1);
                int len1 = r1[1] - r1[0] + 1;
                int len2 = r2[1] - r2[0] + 1;

                if (len1 > len2) {
                    if (maxLen < len1) {
                        left = r1[0];
                        right = r1[1];
                        maxLen = right - left + 1;
                    }
                } else {
                    if (maxLen < len2) {
                        left = r2[0];
                        right = r2[1];
                        maxLen = right - left + 1;
                    }
                }
            }
            return s.substring(left, right + 1);
        }

        public int[] expand(String s, int i, int j) {
            if (i != j && s.charAt(i) != s.charAt(j)) return new int[]{0, 0};
            while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
                i--;
                j++;
            }
            return new int[]{++i, --j};
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}
