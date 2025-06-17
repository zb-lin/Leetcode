//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3
//输出：["((()))","(()())","(())()","()(())","()()()"]
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：["()"]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 8 
// 
//
// Related Topics 字符串 动态规划 回溯 👍 3596 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * 括号生成
 *
 * @author lzb
 * @date 2024-06-10 20:28:56
 */
public class P22_GenerateParentheses {
    public static void main(String[] args) {
        Solution solution = new P22_GenerateParentheses().new Solution();
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        List<String> res = new ArrayList<>();

        public List<String> generateParenthesis(int n) {
            backtrack(n, 0, 0, new StringBuilder());
            return res;
        }

        public void backtrack(int n, int leftCount, int rightCount, StringBuilder sb) {
            if (leftCount + rightCount == n * 2) {
                res.add(sb.toString());
            }
            if (leftCount < n) {
                sb.append('(');
                backtrack(n, leftCount + 1, rightCount, sb);
                sb.deleteCharAt(sb.length() - 1);
            }
            if (rightCount < leftCount) {
                sb.append(')');
                backtrack(n, leftCount, rightCount + 1, sb);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
