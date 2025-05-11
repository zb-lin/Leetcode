//给定一个字符串 s ，请你找出其中不含有重复字符的 最长 子串 的长度。
//
//
//
// 示例 1:
//
//
//输入: s = "abcabcbb"
//输出: 3
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
//
//
// 示例 2:
//
//
//输入: s = "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
//
//
// 示例 3:
//
//
//输入: s = "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
//
//
//
//
// 提示：
//
//
// 0 <= s.length <= 5 * 10⁴
// s 由英文字母、数字、符号和空格组成
//
//
// Related Topics 哈希表 字符串 滑动窗口 👍 10180 👎 0


package leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;

/**
 * 无重复字符的最长子串
 *
 * @author lzb
 * @date 2024-06-10 20:13:01
 */
public class P3_LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        Solution solution = new P3_LongestSubstringWithoutRepeatingCharacters().new Solution();
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int lengthOfLongestSubstring(String s) {
            // 使用哈希集合记录当前窗口中的字符
            Set<Character> charSet = new HashSet<>();
            int maxLength = 0;
            int left = 0;  // 滑动窗口左边界
            int right = 0; // 滑动窗口右边界

            while (right < s.length()) {
                char currentChar = s.charAt(right);

                // 如果字符已存在，移动左边界直到移除重复字符
                if (charSet.contains(currentChar)) {
                    charSet.remove(s.charAt(left));
                    left++;
                } else {
                    // 字符不存在，添加到集合并扩展右边界
                    charSet.add(currentChar);
                    right++;
                    // 更新最大长度
                    maxLength = Math.max(maxLength, right - left);
                }
            }

            return maxLength;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
