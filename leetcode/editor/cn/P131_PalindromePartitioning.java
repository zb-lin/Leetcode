//给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "aab"
//输出：[["a","a","b"],["aa","b"]]
// 
//
// 示例 2： 
//
// 
//输入：s = "a"
//输出：[["a"]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 16 
// s 仅由小写英文字母组成 
// 
//
// Related Topics 字符串 动态规划 回溯 👍 1801 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 分割回文串
 *
 * @author lzb
 * @date 2024-06-26 23:14:45
 */
public class P131_PalindromePartitioning {
    public static void main(String[] args) {
        Solution solution = new P131_PalindromePartitioning().new Solution();
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<List<String>> res = new ArrayList<>();
        LinkedList<String> track = new LinkedList<>();

        public List<List<String>> partition(String s) {
            backtrack(s, 0);
            return res;
        }

        public void backtrack(String s, int startIndex) {
            if (startIndex >= s.length()) {
                res.add(new ArrayList<>(track));
                return;
            }
            for (int i = startIndex; i < s.length(); i++) {
                if (isPalindrome(s, startIndex, i)) {
                    track.add(s.substring(startIndex, i + 1));
                } else {
                    continue;
                }
                backtrack(s, i + 1);
                track.removeLast();
            }
        }

        public boolean isPalindrome(String s, int start, int end) {
            for (int i = start, j = end; i < j; i++, j--) {
                if (s.charAt(i) != s.charAt(j)) {
                    return false;
                }
            }
            return true;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
