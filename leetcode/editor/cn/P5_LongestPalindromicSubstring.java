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
            // max数组存储当前找到的最长回文的起止索引
            // max[0]是起始索引，max[1]是结束索引
            int[] max = {0, 0};

            // 遍历字符串中的每个字符作为可能的回文中心
            for (int i = 0; i < s.length(); i++) {
                // 处理奇数长度的回文（中心为一个字符）
                expand(s, i, i, max);
                // 处理偶数长度的回文（中心为两个相同字符）
                expand(s, i, i + 1, max);
            }

            // 根据记录的起止索引返回最长回文子串
            return s.substring(max[0], max[1] + 1);
        }

        /**
         * 从中心向两边扩展寻找回文
         * @param s 输入字符串
         * @param l 中心左边界（包含）
         * @param r 中心右边界（包含）
         * @param max 记录最长回文起止索引的数组
         */
        private void expand(String s, int l, int r, int[] max) {
            // 向两边扩展，直到字符不匹配或到达字符串边界
            while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                l--;
                r++;
            }

            // 计算当前回文长度（r-l-1）并与当前最大值比较
            // 因为循环结束时l和r已经超出回文边界，所以实际长度是(r-1)-(l+1)+1 = r-l-1
            if (r - l - 1 > max[1] - max[0] + 1) {
                // 更新最长回文索引
                max[0] = l + 1;  // 回文实际开始位置
                max[1] = r - 1;  // 回文实际结束位置
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
