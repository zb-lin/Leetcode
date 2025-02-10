//返回 s 字典序最小的子序列，该子序列包含 s 的所有不同字符，且只包含一次。 
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
// 1 <= s.length <= 1000 
// s 由小写英文字母组成 
// 
//
// 
//
// 注意：该题与 316 https://leetcode.cn/problems/remove-duplicate-letters/ 相同 
//
// Related Topics 栈 贪心 字符串 单调栈 👍 215 👎 0


package leetcode.editor.cn;

/**
 * 不同字符的最小子序列
 *
 * @author lzb
 * @date 2024-09-21 23:12:01
 */
public class P1081_SmallestSubsequenceOfDistinctCharacters {
    public static void main(String[] args) {
        Solution solution = new P1081_SmallestSubsequenceOfDistinctCharacters().new Solution();
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String smallestSubsequence(String s) {
            int[] cnt = new int[26];
            for (char ch : s.toCharArray()) {
                cnt[ch - 'a']++;
            }
            boolean[] inAns = new boolean[26];
            StringBuilder ans = new StringBuilder();
            for (char ch : s.toCharArray()) {
                cnt[ch - 'a']--;
                if (inAns[ch - 'a']) continue;
                while (ans.length() != 0 && ans.charAt(ans.length() - 1) > ch && cnt[ans.charAt(ans.length() - 1) - 'a'] > 0) {
                    inAns[ans.charAt(ans.length() - 1) - 'a'] = false;
                    ans.deleteCharAt(ans.length() - 1);
                }
                inAns[ch - 'a'] = true;
                ans.append(ch);
            }
            return ans.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
