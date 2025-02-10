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

        public String longestPalindrome(String s) {
            int n = s.length();
            int left = 0, right = 0;
            for (int i = 0; i < n; i++) {
                int len1 = expand(s, i, i);
                int len2 = expand(s, i, i + 1);
                int len = Math.max(len1, len2);
                if (len > right - left) {
                    left = i - (len - 1) / 2;
                    right = i + len / 2;
                }
            }
            return s.substring(left, right + 1);
        }

        public int expand(String s, int left, int right) {
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
            }
            return right - left - 1;
        }


/*        public String longestPalindrome(String s) {
            int maxLen = 0;
            int start = 0, end = 0;
            for (int i = 0; i < s.length(); ++i) {
                int result1[] = expand(s, i, i);
                int result2[] = expand(s, i, i + 1);
                int len1 = result1[1] - result1[0] + 1;
                int len2 = result2[1] - result2[0] + 1;
                if (len1 > len2) {
                    if (len1 > maxLen) {
                        maxLen = len1;
                        start = result1[0];
                        end = result1[1];
                    }
                } else {
                    if (len2 > maxLen) {
                        maxLen = len2;
                        start = result2[0];
                        end = result2[1];
                    }
                }
            }
            return s.substring(start, end + 1);
        }

        public int[] expand(String s, int left, int right) {
            if (right >= s.length() || s.charAt(left) != s.charAt(right)) {
                return new int[]{0, 0};
            }
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
            }
            return new int[]{++left, --right};
        }*/



/*        public String longestPalindrome(String s) {
            int len = s.length();
            if (len < 2) return s;
            int start = 0, end = 0;
            for (int i = 0; i < len; ++i) {
                int len1 = expandAroundCenter(s, i, i);
                int len2 = expandAroundCenter(s, i, i + 1);
                int L = Math.max(len1, len2);
                if (L > end - start) {
                    start = i - (L - 1) / 2;
                    end = i + L / 2;
                }
            }
            return s.substring(start, end + 1);
        }

        public int expandAroundCenter(String s, int left, int right) {
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
            }
            return right - left - 1;
        }*/
    }
//leetcode submit region end(Prohibit modification and deletion)

}
