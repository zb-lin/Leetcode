//你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上
//被小偷闯入，系统会自动报警。 
//
// 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。 
//
// 
//
// 示例 1： 
//
// 
//输入：[1,2,3,1]
//输出：4
//解释：偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
//     偷窃到的最高金额 = 1 + 3 = 4 。 
//
// 示例 2： 
//
// 
//输入：[2,7,9,3,1]
//输出：12
//解释：偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
//     偷窃到的最高金额 = 2 + 9 + 1 = 12 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 100 
// 0 <= nums[i] <= 400 
// 
//
// Related Topics 数组 动态规划 👍 2995 👎 0


package leetcode.editor.cn;

import java.util.Arrays;

/**
 * 打家劫舍
 *
 * @author lzb
 * @date 2024-06-10 22:47:33
 */
public class P198_HouseRobber {
    public static void main(String[] args) {
        Solution solution = new P198_HouseRobber().new Solution();
        int[] nums = {1, 2, 3, 1};
        solution.rob(nums);
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int rob(int[] nums) {
            int n = nums.length;
            if (n == 1) return nums[0];
            int[][] dp = new int[n][2];
            dp[0][0] = nums[0];
            dp[1][0] = nums[1];
            dp[1][1] = nums[0];
            int max = Math.max(nums[0], nums[1]);
            for (int i = 2; i < n; ++i) {
                dp[i][0] = Math.max(dp[i - 1][1], dp[i - 2][1]) + nums[i];
                dp[i][1] = dp[i - 1][0];
                max = Math.max(dp[i][0], dp[i][1]);
            }
            return max;
        }

        /*public int rob(int[] nums) {
            if (nums.length == 1) return nums[0];
            int max = Math.max(nums[0], nums[1]);
            if (nums.length == 2) return max;
            max = Math.max(nums[0] + nums[2], nums[1]);
            if (nums.length == 3) return max;

            int[] dp = new int[nums.length];
            dp[0] = nums[0];
            dp[1] = nums[1];
            dp[2] = nums[0] + nums[2];
            for (int i = 3; i < nums.length; ++i) {
                dp[i] = Math.max(nums[i] + dp[i - 2], nums[i] + dp[i - 3]);
                max = Math.max(dp[i], max);
            }
            return max;
        }*/
    }
//leetcode submit region end(Prohibit modification and deletion)

}
