//给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。 
//
// 
//
// 注意： 
//
// 
// 对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。 
// 如果 s 中存在这样的子串，我们保证它是唯一的答案。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "ADOBECODEBANC", t = "ABC"
//输出："BANC"
//解释：最小覆盖子串 "BANC" 包含来自字符串 t 的 'A'、'B' 和 'C'。
// 
//
// 示例 2： 
//
// 
//输入：s = "a", t = "a"
//输出："a"
//解释：整个字符串 s 是最小覆盖子串。
// 
//
// 示例 3: 
//
// 
//输入: s = "a", t = "aa"
//输出: ""
//解释: t 中两个字符 'a' 均应包含在 s 的子串中，
//因此没有符合条件的子字符串，返回空字符串。 
//
// 
//
// 提示： 
//
// 
// m == s.length 
// n == t.length 
// 1 <= m, n <= 10⁵ 
// s 和 t 由英文字母组成 
// 
//
// 
//进阶：你能设计一个在 
//o(m+n) 时间内解决此问题的算法吗？
//
// Related Topics 哈希表 字符串 滑动窗口 👍 2918 👎 0


package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

/**
 * 最小覆盖子串
 *
 * @author lzb
 * @date 2024-06-10 21:51:16
 */
public class P76_MinimumWindowSubstring {
    public static void main(String[] args) {
        Solution solution = new P76_MinimumWindowSubstring().new Solution();
        System.out.println(solution.minWindow("abc", "ac"));
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        Map<Character, Integer> tCount = new HashMap<>();
        Map<Character, Integer> sCount = new HashMap<>();

        public String minWindow(String s, String t) {
            if (s.length() < t.length()) return "";
            for (char ch : t.toCharArray()) {
                tCount.put(ch, tCount.getOrDefault(ch, 0) + 1);
            }
            int start = -1, end = 0, len = s.length() + 1;
            for (int i = 0; i < t.length(); ++i) {
                sCount.put(s.charAt(i), sCount.getOrDefault(s.charAt(i), 0) + 1);
            }
            if (check()) {
                start = 0;
                end = t.length() - 1;
                len = t.length();
            }
            int left = 0;
            for (int i = t.length(); i < s.length(); ++i) {
                sCount.put(s.charAt(i), sCount.getOrDefault(s.charAt(i), 0) + 1);
                while (check()) {
                    if (len > i - left + 1) {
                        start = left;
                        end = i;
                        len = i - left + 1;
                    }

                    sCount.put(s.charAt(left), sCount.getOrDefault(s.charAt(left), 0) - 1);
                    left++;
                }
            }
            return start != -1 ? s.substring(start, end + 1) : "";
        }

        public boolean check() {
            for (char ch : tCount.keySet()) {
                if (tCount.get(ch) > sCount.getOrDefault(ch, 0)) {
                    return false;
                }
            }
            return true;
        }
/*        Map<Character, Integer> sCount = new HashMap<>();
        Map<Character, Integer> tCount = new HashMap<>();

        public String minWindow(String s, String t) {
            if (t.length() > s.length()) return "";
            for (int i = 0; i < t.length(); i++) {
                tCount.put(t.charAt(i), tCount.getOrDefault(t.charAt(i), 0) + 1);
                sCount.put(s.charAt(i), sCount.getOrDefault(s.charAt(i), 0) + 1);
            }
            if (check()) {
                return s.substring(0, t.length());
            }
            int minLen = s.length(), left = 0;
            int start = -1, end = 0;
            for (int i = t.length(); i < s.length(); i++) {
                sCount.put(s.charAt(i), sCount.getOrDefault(s.charAt(i), 0) + 1);
                while (check()) {
                    if (i - left + 1 <= minLen) {
                        minLen = i - left + 1;
                        start = left;
                        end = i;
                    }
                    sCount.put(s.charAt(left), sCount.get(s.charAt(left)) - 1);
                    left++;
                }
            }
            return start != -1 ? s.substring(start, end + 1) : "";
        }

        public boolean check() {
            for (Map.Entry<Character, Integer> entry : tCount.entrySet()) {
                Character key = entry.getKey();
                Integer value = entry.getValue();
                if (sCount.getOrDefault(key, 0) < value) {
                    return false;
                }
            }
            return true;
        }*/
    }
//leetcode submit region end(Prohibit modification and deletion)

}
