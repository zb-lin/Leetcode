//给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。 
//
// 如果反转后整数超过 32 位的有符号整数的范围 [−2³¹, 231 − 1] ，就返回 0。 
//假设环境不允许存储 64 位整数（有符号或无符号）。
//
// 
//
// 示例 1： 
//
// 
//输入：x = 123
//输出：321
// 
//
// 示例 2： 
//
// 
//输入：x = -123
//输出：-321
// 
//
// 示例 3： 
//
// 
//输入：x = 120
//输出：21
// 
//
// 示例 4： 
//
// 
//输入：x = 0
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// -2³¹ <= x <= 2³¹ - 1 
// 
//
// Related Topics 数学 👍 4018 👎 0


package leetcode.editor.cn;

/**
 * 整数反转
 *
 * @author lzb
 * @date 2024-09-09 11:44:59
 */
public class P7_ReverseInteger {
    public static void main(String[] args) {
        Solution solution = new P7_ReverseInteger().new Solution();
        solution.reverse(1534236469);
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int reverse(int x) {
            int res = 0;
            while (x != 0) {
                if (res < Integer.MIN_VALUE / 10 || res > Integer.MAX_VALUE / 10) {
                    return 0;
                }
                int digit = x % 10;
                x /= 10;
                res = res * 10 + digit;
            }
            return res;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
