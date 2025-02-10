//给定一个非空的字符串
// s ，检查是否可以通过由它的一个子串重复多次构成。 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "abab"
//输出: true
//解释: 可由子串 "ab" 重复两次构成。
// 
//
// 示例 2: 
//
// 
//输入: s = "aba"
//输出: false
// 
//
// 示例 3: 
//
// 
//输入: s = "abcabcabcabc"
//输出: true
//解释: 可由子串 "abc" 重复四次构成。 (或子串 "abcabc" 重复两次构成。)
// 
//
// 
//
// 提示： 
//
// 
// 
//
// 
// 1 <= s.length <= 10⁴ 
// s 由小写英文字母组成 
// 
//
// Related Topics 字符串 字符串匹配 👍 1175 👎 0


package leetcode.editor.cn;

import java.lang.reflect.Field;

/**
 * 重复的子字符串
 *
 * @author lzb
 * @date 2024-06-21 18:58:25
 */
public class P459_RepeatedSubstringPattern {
    public static void main(String[] args) {
        Solution solution = new P459_RepeatedSubstringPattern().new Solution();
        solution.repeatedSubstringPattern("abab");
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean repeatedSubstringPattern(String s) {
            int length = s.length();
            for (int i = 1; i < length; ++i) {
                if (length % i != 0) continue;
                String str = s.substring(0, i);
                boolean flag = true;
                for (int j = i; j < length; j += i) {
                    if (!s.substring(j, j + i).equals(str)) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    return true;
                }
            }
            return false;
        }
        /*public boolean repeatedSubstringPattern(String s) {
            int length = s.length();
            int[] next = getNext(s);
            return next[length - 1] != 0 && (length % (length - next[length - 1]) == 0);
        }

        public int[] getNext(String s) {
            int length = s.length();
            int[] next = new int[length];
            int j = 0;
            for (int i = 1; i < length; i++) {
                while (j > 0 && s.charAt(i) != s.charAt(j)) {
                    j = next[j - 1];
                }
                if (s.charAt(i) == s.charAt(j)) {
                    j++;
                }
                next[i] = j;
            }
            return next;
        }*/

    }
//leetcode submit region end(Prohibit modification and deletion)

}
