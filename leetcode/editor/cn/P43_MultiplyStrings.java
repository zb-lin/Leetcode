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
            // 处理乘数为0的情况
            if (num1.equals("0") || num2.equals("0")) {
                return "0";
            }

            // 初始化结果数组（最大长度为 m + n）
            int m = num1.length(), n = num2.length();
            int[] result = new int[m + n];

            // 从低位到高位逐位相乘
            for (int i = m - 1; i >= 0; i--) {
                int digit1 = num1.charAt(i) - '0';
                for (int j = n - 1; j >= 0; j--) {
                    int digit2 = num2.charAt(j) - '0';
                    int product = digit1 * digit2;

                    // 计算当前位的位置和总和
                    int sum = product + result[i + j + 1];
                    result[i + j + 1] = sum % 10;  // 当前位的值
                    result[i + j] += sum / 10;     // 进位
                }
            }

            // 将结果数组转换为字符串
            StringBuilder sb = new StringBuilder();
            for (int num : result) {
                // 跳过前导零
                if (sb.length() == 0 && num == 0) {
                    continue;
                }
                sb.append(num);
            }

            return sb.length() == 0 ? "0" : sb.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
