//给你两个字符串 s1 和 s2 ，写一个函数来判断 s2 是否包含 s1 的 排列。如果是，返回 true ；否则，返回 false 。 
//
// 换句话说，s1 的排列之一是 s2 的 子串 。 
//
// 
//
// 示例 1： 
//
// 
//输入：s1 = "ab" s2 = "eidbaooo"
//输出：true
//解释：s2 包含 s1 的排列之一 ("ba").
// 
//
// 示例 2： 
//
// 
//输入：s1= "ab" s2 = "eidboaoo"
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s1.length, s2.length <= 10⁴ 
// s1 和 s2 仅包含小写字母 
// 
//
// Related Topics 哈希表 双指针 字符串 滑动窗口 👍 1028 👎 0


package leetcode.editor.cn;

import java.util.Arrays;

/**
 * 字符串的排列
 *
 * @author lzb
 * @date 2024-10-08 14:31:58
 */
public class P567_PermutationInString {
    public static void main(String[] args) {
        Solution solution = new P567_PermutationInString().new Solution();
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int[] countS1 = new int[26];
        int[] countS2 = new int[26];

        public boolean checkInclusion(String s1, String s2) {
            int m = s1.length(), n = s2.length();
            if (m > n) return false;
            for (int i = 0; i < m; i++) {
                countS1[s1.charAt(i) - 'a']++;
                countS2[s2.charAt(i) - 'a']++;
            }
            if (check()) return true;
            for (int i = m; i < n; i++) {
                countS2[s2.charAt(i - m) - 'a']--;
                countS2[s2.charAt(i) - 'a']++;
                if (check()) return true;
            }
            return false;
        }

        public boolean check() {
            return Arrays.equals(countS1, countS2);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
