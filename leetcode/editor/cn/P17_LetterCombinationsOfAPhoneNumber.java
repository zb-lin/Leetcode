//给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。 
//
// 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。 
//
// 
//
// 
//
// 示例 1： 
//
// 
//输入：digits = "23"
//输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
// 
//
// 示例 2： 
//
// 
//输入：digits = ""
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：digits = "2"
//输出：["a","b","c"]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= digits.length <= 4 
// digits[i] 是范围 ['2', '9'] 的一个数字。 
// 
//
// Related Topics 哈希表 字符串 回溯 👍 2835 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 电话号码的字母组合
 *
 * @author lzb
 * @date 2024-06-10 20:25:16
 */
public class P17_LetterCombinationsOfAPhoneNumber {
    public static void main(String[] args) {
        Solution solution = new P17_LetterCombinationsOfAPhoneNumber().new Solution();
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<String> res = new ArrayList<>();
        Map<Character, String> record;

        public List<String> letterCombinations(String digits) {
            if ("".equals(digits)) return res;
            record = new HashMap<>();
            record.put('2', "abc");
            record.put('3', "def");
            record.put('4', "ghi");
            record.put('5', "jkl");
            record.put('6', "mno");
            record.put('7', "pqrs");
            record.put('8', "tuv");
            record.put('9', "wxyz");
            backtrack(digits, 0, new StringBuilder());
            return res;
        }

        public void backtrack(String digits, int index, StringBuilder sb) {
            if (sb.length() == digits.length()) {
                res.add(sb.toString());
                return;
            }
            for (char ch : record.get(digits.charAt(index)).toCharArray()) {
                sb.append(ch);
                backtrack(digits, index + 1, sb);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
