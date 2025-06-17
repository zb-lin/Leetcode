//给你一个字符串 s 和一个字符串列表 wordDict 作为字典。如果可以利用字典中出现的一个或多个单词拼接出 s 则返回 true。 
//
// 注意：不要求字典中出现的单词全部都使用，并且字典中的单词可以重复使用。 
//
// 
//
// 示例 1： 
//
// 
//输入: s = "leetcode", wordDict = ["leet", "code"]
//输出: true
//解释: 返回 true 因为 "leetcode" 可以由 "leet" 和 "code" 拼接成。
// 
//
// 示例 2： 
//
// 
//输入: s = "applepenapple", wordDict = ["apple", "pen"]
//输出: true
//解释: 返回 true 因为 "applepenapple" 可以由 "apple" "pen" "apple" 拼接成。
//     注意，你可以重复使用字典中的单词。
// 
//
// 示例 3： 
//
// 
//输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
//输出: false
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 300 
// 1 <= wordDict.length <= 1000 
// 1 <= wordDict[i].length <= 20 
// s 和 wordDict[i] 仅由小写英文字母组成 
// wordDict 中的所有字符串 互不相同 
// 
//
// Related Topics 字典树 记忆化搜索 数组 哈希表 字符串 动态规划 👍 2516 👎 0


package leetcode.editor.cn;

import java.util.List;

/**
 * 单词拆分
 *
 * @author lzb
 * @date 2024-06-10 22:28:54
 */
public class P139_WordBreak {
    public static void main(String[] args) {
        Solution solution = new P139_WordBreak().new Solution();
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public boolean wordBreak(String s, List<String> wordDict) {
            int n = s.length();
            boolean[] dp = new boolean[n + 1];
            dp[0] = true;
            for (int i = 1; i <= n; ++i) {
                for (String word : wordDict) {
                    int len = word.length();
                    if (i < len) continue;
                    if (dp[i - len] && s.substring(i - len, i).equals(word)) {
                        dp[i] = true;
                        break;
                    }
                }
            }
            return dp[n];
        }

        // 回溯
        boolean flag = false;
        StringBuilder track = new StringBuilder();

        public boolean wordBreak1(String s, List<String> wordDict) {
            backtrack(s, wordDict);
            return flag;
        }

        public void backtrack(String s, List<String> wordDict) {
            if (s.contentEquals(track)) {
                flag = true;
                return;
            }
            if (track.length() >= s.length()) return;
            for (int i = 0; i < wordDict.size(); ++i) {
                track.append(wordDict.get(i));
                backtrack(s, wordDict);
                track.delete(track.length() - wordDict.get(i).length(), track.length());
            }

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
