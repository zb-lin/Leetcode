//给你两个整数，被除数 dividend 和除数 divisor。将两数相除，要求 不使用 乘法、除法和取余运算。 
//
// 整数除法应该向零截断，也就是截去（truncate）其小数部分。例如，8.345 将被截断为 8 ，-2.7335 将被截断至 -2 。 
//
// 返回被除数 dividend 除以除数 divisor 得到的 商 。 
//
// 注意：假设我们的环境只能存储 32 位 有符号整数，其数值范围是 [−2³¹, 231 − 1] 。本题中，如果商 严格大于 231 − 1 ，则返回 2
//31 − 1 ；如果商 严格小于 -2³¹ ，则返回 -2³¹ 。 
//
// 
//
// 示例 1: 
//
// 
//输入: dividend = 10, divisor = 3
//输出: 3
//解释: 10/3 = 3.33333.. ，向零截断后得到 3 。 
//
// 示例 2: 
//
// 
//输入: dividend = 7, divisor = -3
//输出: -2
//解释: 7/-3 = -2.33333.. ，向零截断后得到 -2 。 
//
// 
//
// 提示： 
//
// 
// -2³¹ <= dividend, divisor <= 2³¹ - 1 
// divisor != 0 
// 
//
// Related Topics 位运算 数学 👍 1227 👎 0


package leetcode.editor.cn;

/**
 * 两数相除
 *
 * @author lzb
 * @date 2024-05-24 10:25:55
 */
public class P29_DivideTwoIntegers {
    public static void main(String[] args) {
        Solution solution = new P29_DivideTwoIntegers().new Solution();
        solution.divide(-2147483648, -1);
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int divide(int dividend, int divisor) {
            if (dividend == Integer.MIN_VALUE) {
                if (divisor == 1) {
                    return Integer.MIN_VALUE;
                }
                if (divisor == -1) {
                    return Integer.MAX_VALUE;
                }
            }
            if (divisor == Integer.MIN_VALUE) {
                return dividend == Integer.MIN_VALUE ? 1 : 0;
            }
            if (dividend == 0) return 0;
            boolean rev = false;
            if (divisor > 0) {
                rev = !rev;
                divisor = -divisor;
            }
            if (dividend > 0) {
                rev = !rev;
                dividend = -dividend;
            }
            int left = 1, right = Integer.MAX_VALUE, ans = 0;
            while (left <= right) {
                int mid = left + ((right - left) >> 1);
                boolean check = quickAdd(divisor, mid, dividend);
                if (check) {
                    ans = mid;
                    if (mid == Integer.MAX_VALUE) {
                        break;
                    }
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            return rev ? -ans : ans;
        }

        public boolean quickAdd(int y, int z, int x) {
            int result = 0, add = y;
            while (z != 0) {
                if ((z & 1) != 0) {
                    if (result < x - add) {
                        return false;
                    }
                    result += add;
                }
                if (z != 1) {
                    if (add < x - add) {
                        return false;
                    }
                    add += add;
                }
                z >>= 1;
            }
            return true;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
