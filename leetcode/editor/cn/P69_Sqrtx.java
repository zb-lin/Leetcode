//给你一个非负整数 x ，计算并返回 x 的 算术平方根 。 
//
// 由于返回类型是整数，结果只保留 整数部分 ，小数部分将被 舍去 。 
//
// 注意：不允许使用任何内置指数函数和算符，例如 pow(x, 0.5) 或者 x ** 0.5 。 
//
// 
//
// 示例 1： 
//
// 
//输入：x = 4
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：x = 8
//输出：2
//解释：8 的算术平方根是 2.82842..., 由于返回类型是整数，小数部分将被舍去。
// 
//
// 
//
// 提示： 
//
// 
// 0 <= x <= 2³¹ - 1 
// 
//
// Related Topics 数学 二分查找 👍 1551 👎 0


package leetcode.editor.cn;

/**
 * x 的平方根
 *
 * @author lzb
 * @date 2024-06-18 19:55:37
 */
public class P69_Sqrtx {
    public static void main(String[] args) {
        Solution solution = new P69_Sqrtx().new Solution();

    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int mySqrt(int x) {
            // 处理特殊情况
            if (x == 0 || x == 1) {
                return x;
            }

            // 初始化左右边界
            long left = 1;
            long right = x;
            long result = 0;

            // 二分查找
            while (left <= right) {
                long mid = left + (right - left) / 2;
                long square = mid * mid;

                if (square == x) {
                    return (int) mid;  // 找到精确平方根
                } else if (square < x) {
                    left = mid + 1;
                    result = mid;      // 记录当前最接近的较小值
                } else {
                    right = mid - 1;
                }
            }

            return (int) result;  // 返回整数部分
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
