//给你一个字符串表达式 s ，请你实现一个基本计算器来计算并返回它的值。 
//
// 整数除法仅保留整数部分。 
//
// 你可以假设给定的表达式总是有效的。所有中间结果将在 [-2³¹, 2³¹ - 1] 的范围内。 
//
// 注意：不允许使用任何将字符串作为数学表达式计算的内置函数，比如 eval() 。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "3+2*2"
//输出：7
// 
//
// 示例 2： 
//
// 
//输入：s = " 3/2 "
//输出：1
// 
//
// 示例 3： 
//
// 
//输入：s = " 3+5 / 2 "
//输出：5
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 3 * 10⁵ 
// s 由整数和算符 ('+', '-', '*', '/') 组成，中间由一些空格隔开 
// s 表示一个 有效表达式 
// 表达式中的所有整数都是非负整数，且在范围 [0, 2³¹ - 1] 内 
// 题目数据保证答案是一个 32-bit 整数 
// 
//
// Related Topics 栈 数学 字符串 👍 791 👎 0


package leetcode.editor.cn;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Objects;

/**
 * 基本计算器 II
 *
 * @author lzb
 * @date 2024-09-04 22:11:09
 */
public class P227_BasicCalculatorIi {
    public static void main(String[] args) {
        Solution solution = new P227_BasicCalculatorIi().new Solution();
        System.out.println(solution.calculate("1-1+1"));
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int ptr = 0;
        String src;

        public int calculate(String s) {
            src = s;
            Deque<String> deque = new LinkedList<>();
            while (ptr < src.length()) {
                char curr = src.charAt(ptr);
                if (Character.isDigit(curr)) {
                    deque.push(String.valueOf(getDigit()));
                } else if (curr == '-' || curr == '+') {
                    deque.push(String.valueOf(curr));
                    ptr++;
                } else if (curr == '/') {
                    ptr++;
                    int num1 = getDigit();
                    int num2 = Integer.parseInt(deque.pop());
                    deque.push(String.valueOf(num2 / num1));
                } else if (curr == '*') {
                    ptr++;
                    int num1 = getDigit();
                    int num2 = Integer.parseInt(deque.pop());
                    deque.push(String.valueOf(num1 * num2));
                } else {
                    ptr++;
                }
            }
            while (deque.size() > 1) {
                int num1 = Integer.parseInt(deque.pop());
                String curr = deque.pop();
                int num2 = Integer.parseInt(deque.pop());
                if (Objects.equals(deque.peek(), "-")) {
                    curr = "+".equals(curr) ? "-" : "+";
                }
                if (Objects.equals(curr, "+")) {
                    deque.push(String.valueOf(num1 + num2));
                } else if (Objects.equals(curr, "-")) {
                    deque.push(String.valueOf(num2 - num1));
                }
            }
            return Integer.parseInt(deque.pop());
        }

        public int getDigit() {
            int res = 0;
            while (ptr < src.length() && src.charAt(ptr) == ' ') ptr++;
            while (ptr < src.length() && Character.isDigit(src.charAt(ptr))) {
                res = res * 10 + src.charAt(ptr++) - '0';
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
