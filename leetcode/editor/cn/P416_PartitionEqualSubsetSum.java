//给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,5,11,5]
//输出：true
//解释：数组可以分割成 [1, 5, 5] 和 [11] 。 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3,5]
//输出：false
//解释：数组不能分割成两个元素和相等的子集。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 200 
// 1 <= nums[i] <= 100 
// 
//
// Related Topics 数组 动态规划 👍 2101 👎 0


package leetcode.editor.cn;

import java.util.Arrays;

/**
 * 分割等和子集
 *
 * @author lzb
 * @date 2024-07-01 00:14:52
 */
public class P416_PartitionEqualSubsetSum {
    public static void main(String[] args) {
        Solution solution = new P416_PartitionEqualSubsetSum().new Solution();
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean canPartition(int[] nums) {
            int sum = Arrays.stream(nums).sum();
            if (sum % 2 != 0) return false;
            int target = sum / 2;
            int[][] dp = new int[nums.length][target + 1];
            for (int j = 1; j <= target; j++) {
                dp[0][j] = j > nums[0] ? nums[0] : 0;
            }
            for (int i = 1; i < nums.length; i++) {
                for (int j = 1; j <= target; j++) {
                    if (j < nums[i]) {
                        dp[i][j] = dp[i - 1][j];
                    } else {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - nums[i]] + nums[i]);
                    }
                }
            }
            return dp[nums.length - 1][target] == target;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
