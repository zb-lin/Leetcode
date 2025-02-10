//给你一个字符串 s ，请你去除字符串中重复的字母，使得每个字母只出现一次。需保证 返回结果的字典序最小（要求不能打乱其他字符的相对位置）。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "bcabc"
//输出："abc"
// 
//
// 示例 2： 
//
// 
//输入：s = "cbacdcbc"
//输出："acdb" 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 10⁴ 
// s 由小写英文字母组成 
// 
//
// 
//
// 注意：该题与 1081 https://leetcode-cn.com/problems/smallest-subsequence-of-
//distinct-characters 相同 
//
// Related Topics 栈 贪心 字符串 单调栈 👍 1107 👎 0


package leetcode.editor.cn;

/**
 * 去除重复字母
 *
 * @author lzb
 * @date 2024-09-21 22:55:25
 */
public class P316_RemoveDuplicateLetters {
    public static void main(String[] args) {
        Solution solution = new P316_RemoveDuplicateLetters().new Solution();
        solution.removeDuplicateLetters("bcabc");
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String removeDuplicateLetters(String s) {
            int[] cnt = new int[26];
            for (char ch : s.toCharArray()) {
                cnt[ch - 'a']++;
            }
            StringBuilder ans = new StringBuilder(26);
            boolean[] inAns = new boolean[26];
            for (char ch : s.toCharArray()) {
                cnt[ch - 'a']--;
                if (inAns[ch - 'a']) continue;
                while (ans.length() != 0 && ans.charAt(ans.length() - 1) > ch && cnt[ans.charAt(ans.length() - 1) - 'a'] > 0) {
                    inAns[ans.charAt(ans.length() - 1) - 'a'] = false;
                    ans.deleteCharAt(ans.length() - 1);
                }
                ans.append(ch);
                inAns[ch - 'a'] = true;
            }
            return ans.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
