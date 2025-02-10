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
            // 保存已出现的字母
            Set<Character> set = new HashSet<>();
            int n = s.length(), right = -1, res = 0;
            for (int i = 0; i < n; i++) {
                // 每次删除最前面一个字符
                if (i != 0) {
                    set.remove(s.charAt(i - 1));
                }
                // 移动右指针, 找到合法的最长子串
                while (right + 1 < n && !set.contains(s.charAt(right + 1))) {
                    set.add(s.charAt(right + 1));
                    right++;
                }
                res = Math.max(res, right - i + 1);
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
