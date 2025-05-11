//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。 
//
// 有效字符串需满足： 
//
// 
// 左括号必须用相同类型的右括号闭合。 
// 左括号必须以正确的顺序闭合。 
// 每个右括号都有一个对应的相同类型的左括号。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "()"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：s = "()[]{}"
//输出：true
// 
//
// 示例 3： 
//
// 
//输入：s = "(]"
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 10⁴ 
// s 仅由括号 '()[]{}' 组成 
// 
//
// Related Topics 栈 字符串 👍 4457 👎 0


package leetcode.editor.cn;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 有效的括号
 *
 * @author lzb
 * @date 2024-06-10 20:27:15
 */
public class P20_ValidParentheses {
    public static void main(String[] args) {
        Solution solution = new P20_ValidParentheses().new Solution();
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isValid(String s) {
            Deque<Character> record = new LinkedList<>();
            for (int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);
                if (record.isEmpty() || isLeft(ch)) {
                    record.addFirst(ch);
                } else if (record.getFirst() == reverse(ch)) {
                    record.removeFirst();
                } else {
                    return false;
                }
            }
            return record.isEmpty();
        }
        public boolean isLeft(char ch) {
            return ch == '(' || ch == '[' || ch == '{';
        }
        public char reverse(char ch) {
            if (ch == ')') return '(';
            if (ch == ']') return '[';
            return '{';
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
