//给你一个字符串 s 和一个字符串数组 dictionary ，找出并返回 dictionary 中最长的字符串，该字符串可以通过删除 s 中的某些字符得到。
// 
//
// 如果答案不止一个，返回长度最长且字母序最小的字符串。如果答案不存在，则返回空字符串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "abpcplea", dictionary = ["ale","apple","monkey","plea"]
//输出："apple"
// 
//
// 示例 2： 
//
// 
//输入：s = "abpcplea", dictionary = ["a","b","c"]
//输出："a"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// 1 <= dictionary.length <= 1000 
// 1 <= dictionary[i].length <= 1000 
// s 和 dictionary[i] 仅由小写英文字母组成 
// 
//
// Related Topics 数组 双指针 字符串 排序 👍 373 👎 0


package leetcode.editor.cn;

import java.util.Collections;
import java.util.List;

/**
 * 通过删除字母匹配到字典里最长单词
 *
 * @author lzb
 * @date 2024-09-18 22:04:20
 */
public class P524_LongestWordInDictionaryThroughDeleting {
    public static void main(String[] args) {
        Solution solution = new P524_LongestWordInDictionaryThroughDeleting().new Solution();
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String findLongestWord(String s, List<String> dictionary) {
            dictionary.sort((a, b) -> a.length() != b.length() ? b.length() - a.length() : a.compareTo(b));
            for (String word : dictionary) {
                int wordIndex = 0, sIndex = 0;
                while (wordIndex < word.length() && sIndex < s.length()) {
                    if (word.charAt(wordIndex) == s.charAt(sIndex)) {
                        wordIndex++;
                    }
                    sIndex++;
                }
                if (wordIndex == word.length()) {
                    return word;
                }
            }
            return "";
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
