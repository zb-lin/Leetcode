//给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。 
//
// 注意：不能使用任何内置的 BigInteger 库或直接将输入转换为整数。 
//
// 
//
// 示例 1: 
//
// 
//输入: num1 = "2", num2 = "3"
//输出: "6" 
//
// 示例 2: 
//
// 
//输入: num1 = "123", num2 = "456"
//输出: "56088" 
//
// 
//
// 提示： 
//
// 
// 1 <= num1.length, num2.length <= 200 
// num1 和 num2 只能由数字组成。 
// num1 和 num2 都不包含任何前导零，除了数字0本身。 
// 
//
// Related Topics 数学 字符串 模拟 👍 1366 👎 0


package leetcode.editor.cn;

/**
 * 字符串相乘
 *
 * @author lzb
 * @date 2024-09-03 15:37:36
 */
public class P43_MultiplyStrings {
    public static void main(String[] args) {
        Solution solution = new P43_MultiplyStrings().new Solution();
        solution.multiply("123", "456");
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String multiply(String num1, String num2) {
            if (num1.equals("0") || num2.equals("0")) return "0";
            String result = "";
            for (int i = num2.length() - 1; i >= 0; i--) {
                int num = num2.charAt(i) - '0';
                StringBuilder temp = new StringBuilder(multiply(num1, num));
                for (int j = 0; j < num2.length() - i - 1; j++) {
                    temp.append(0);
                }
                result = addStrings(result, temp.toString());
            }
            return result;
        }

        public String multiply(String num1, int num2) {
            StringBuilder sb = new StringBuilder();
            int index = num1.length() - 1, carry = 0;
            while (index >= 0 || carry > 0) {
                int temp = (index >= 0 ? (num1.charAt(index) - '0') * num2 : 0) + carry;
                sb.append(temp % 10);
                carry = temp / 10;
                index--;
            }
            return sb.reverse().toString();
        }

        public String addStrings(String num1, String num2) {
            int len1 = num1.length(), len2 = num2.length();
            int index1 = len1 - 1, index2 = len2 - 1, carry = 0;
            StringBuilder sb = new StringBuilder();
            while (index1 >= 0 || index2 >= 0 || carry > 0) {
                int temp = (index1 >= 0 ? num1.charAt(index1) - '0' : 0)
                        + (index2 >= 0 ? num2.charAt(index2) - '0' : 0) + carry;
                sb.append(temp % 10);
                carry = temp / 10;
                index1--;
                index2--;
            }
            return sb.reverse().toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
