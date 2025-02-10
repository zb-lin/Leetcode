//给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和并同样以字符串形式返回。 
//
// 你不能使用任何內建的用于处理大整数的库（比如 BigInteger）， 也不能直接将输入的字符串转换为整数形式。 
//
// 
//
// 示例 1： 
//
// 
//输入：num1 = "11", num2 = "123"
//输出："134"
// 
//
// 示例 2： 
//
// 
//输入：num1 = "456", num2 = "77"
//输出："533"
// 
//
// 示例 3： 
//
// 
//输入：num1 = "0", num2 = "0"
//输出："0"
// 
//
// 
//
// 
//
// 提示： 
//
// 
// 1 <= num1.length, num2.length <= 10⁴ 
// num1 和num2 都只包含数字 0-9 
// num1 和num2 都不包含任何前导零 
// 
//
// Related Topics 数学 字符串 模拟 👍 848 👎 0


package leetcode.editor.cn;

/**
 * 字符串相加
 *
 * @author lzb
 * @date 2024-08-30 14:57:39
 */
public class P415_AddStrings {
    public static void main(String[] args) {
        Solution solution = new P415_AddStrings().new Solution();
        System.out.println(solution.addStrings("1", "9"));
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String addStrings(String num1, String num2) {
            int index1 = num1.length() - 1, index2 = num2.length() - 1;
            int num = 0;
            StringBuilder sb = new StringBuilder();
            while (index1 >= 0 || index2 >= 0) {
                int result = (index1 >= 0 ? num1.charAt(index1) - '0' : 0) +
                        (index2 >= 0 ? num2.charAt(index2) - '0' : 0) + num;
                sb.append(result % 10);
                num = result / 10;
                index1--;
                index2--;
            }
            if (num != 0) sb.append(num);
            return sb.reverse().toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
