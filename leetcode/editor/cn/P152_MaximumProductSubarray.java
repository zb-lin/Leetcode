//给你一个整数数组 nums ，请你找出数组中乘积最大的非空连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。 
//
// 测试用例的答案是一个 32-位 整数。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [2,3,-2,4]
//输出: 6
//解释: 子数组 [2,3] 有最大乘积 6。
// 
//
// 示例 2: 
//
// 
//输入: nums = [-2,0,-1]
//输出: 0
//解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。 
//
// 
//
// 提示: 
//
// 
// 1 <= nums.length <= 2 * 10⁴ 
// -10 <= nums[i] <= 10 
// nums 的任何前缀或后缀的乘积都 保证 是一个 32-位 整数 
// 
//
// Related Topics 数组 动态规划 👍 2250 👎 0


package leetcode.editor.cn;

/**
 * 乘积最大子数组
 *
 * @author lzb
 * @date 2024-06-10 22:39:18
 */
public class P152_MaximumProductSubarray {
    public static void main(String[] args) {
        Solution solution = new P152_MaximumProductSubarray().new Solution();
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxProduct(int[] nums) {
            int max = nums[0], min = nums[0];
            int result = nums[0];
            for (int i = 1; i < nums.length; ++i) {
                int temp = max;
                max = compare(nums[i], nums[i] * max, nums[i] * min, true);
                min = compare(nums[i], nums[i] * temp, nums[i] * min, false);
                result = Math.max(result, max);
            }
            return result;
        }

        public int compare(int num1, int num2, int num3, boolean isMax) {
            if (isMax) {
                return Math.max(Math.max(num1, num2), num3);
            } else {
                return Math.min(Math.min(num1, num2), num3);
            }
        }

/*        public int maxProduct(int[] nums) {
            int length = nums.length;
            int minF = nums[0];
            int maxF = nums[0];
            int res = nums[0];
            for (int i = 1; i < length; ++i) {
                int tmp = maxF;
                maxF = Math.max(maxF * nums[i], Math.max(minF * nums[i], nums[i]));
                minF = Math.min(tmp * nums[i], Math.min(minF * nums[i], nums[i]));
                res = Math.max(res, maxF);
            }
            return res;
        }*/
    }
//leetcode submit region end(Prohibit modification and deletion)

}
