//给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串的第一个匹配项的下标（下标从 0 开始）。
//如果 needle 不是 haystack 的一部分，则返回 -1 。 
//
// 
//
// 示例 1： 
//
// 
//输入：haystack = "sadbutsad", needle = "sad"
//输出：0
//解释："sad" 在下标 0 和 6 处匹配。
//第一个匹配项的下标是 0 ，所以返回 0 。
// 
//
// 示例 2： 
//
// 
//输入：haystack = "leetcode", needle = "leeto"
//输出：-1
//解释："leeto" 没有在 "leetcode" 中出现，所以返回 -1 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= haystack.length, needle.length <= 10⁴ 
// haystack 和 needle 仅由小写英文字符组成 
// 
//
// Related Topics 双指针 字符串 字符串匹配 👍 2243 👎 0


package leetcode.editor.cn;

/**
 * 找出字符串中第一个匹配项的下标
 *
 * @author lzb
 * @date 2024-06-21 18:49:52
 */
public class P28_FindTheIndexOfTheFirstOccurrenceInAString {
    public static void main(String[] args) {
        Solution solution = new P28_FindTheIndexOfTheFirstOccurrenceInAString().new Solution();
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
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
        }

        public int strStr(String haystack, String needle) {
            int[] next = getNext(needle);
            int j = 0;
            for (int i = 0; i < haystack.length(); i++) {
                while (j > 0 && needle.charAt(j) != haystack.charAt(i)) {
                    j = next[j - 1];
                }
                if (needle.charAt(j) == haystack.charAt(i)) {
                    j++;
                }
                if (j == needle.length()) {
                    return i - needle.length() + 1;
                }
            }
            return -1;
        }
  /*      public int strStr(String haystack, String needle) {
            int n = haystack.length(), m = needle.length();
            if (n < m) return -1;
            for (int i = 0; i <= n - m; i++) {
                if (needle.equals(haystack.substring(i, i + m))) {
                    return i;
                }
            }
            return -1;
        }*/
    }
//leetcode submit region end(Prohibit modification and deletion)

}
