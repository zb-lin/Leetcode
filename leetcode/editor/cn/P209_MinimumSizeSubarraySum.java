//给定一个含有 n 个正整数的数组和一个正整数 target 。 
//
// 找出该数组中满足其总和大于等于 target 的长度最小的 子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其
//长度。如果不存在符合条件的子数组，返回 0 。 
//
// 
//
// 示例 1： 
//
// 
//输入：target = 7, nums = [2,3,1,2,4,3]
//输出：2
//解释：子数组 [4,3] 是该条件下的长度最小的子数组。
// 
//
// 示例 2： 
//
// 
//输入：target = 4, nums = [1,4,4]
//输出：1
// 
//
// 示例 3： 
//
// 
//输入：target = 11, nums = [1,1,1,1,1,1,1,1]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= target <= 10⁹ 
// 1 <= nums.length <= 10⁵ 
// 1 <= nums[i] <= 10⁵ 
// 
//
// 
//
// 进阶： 
//
// 
// 如果你已经实现 O(n) 时间复杂度的解法, 请尝试设计一个 O(n log(n)) 时间复杂度的解法。 
// 
//
// Related Topics 数组 二分查找 前缀和 滑动窗口 👍 2150 👎 0


package leetcode.editor.cn;

import java.util.Arrays;

/**
 * 长度最小的子数组
 *
 * @author lzb
 * @date 2024-06-18 22:00:02
 */
public class P209_MinimumSizeSubarraySum {
    public static void main(String[] args) {
        Solution solution = new P209_MinimumSizeSubarraySum().new Solution();
        int[] nums = {2, 3, 1, 2, 4, 3};
        solution.minSubArrayLen(7, nums);
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minSubArrayLen(int target, int[] nums) {
            int n = nums.length;
            int left = 0, ans = 0, minLen = Integer.MAX_VALUE;
            for (int right = 0; right < n; ++right) {
                ans += nums[right];
                while (left <= right && ans >= target) {
                    minLen = Math.min(minLen, right - left + 1);
                    ans -= nums[left++];
                }
            }
            return minLen == Integer.MAX_VALUE ? 0 : minLen;
        }

        /**
         * '
         * 前缀和 + 二分查找
         */
        public int minSubArrayLen1(int targetSum, int[] nums) {
            int n = nums.length;
            if (n == 0) {
                return 0;
            }

            // 1. 计算前缀和数组
            int[] prefixSum = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                prefixSum[i] = prefixSum[i - 1] + nums[i - 1];
            }

            int minLength = Integer.MAX_VALUE;

            // 2. 遍历每个起始点 i，寻找满足条件的子数组
            for (int i = 0; i < n; i++) {
                // 目标前缀和：prefixSum[j] >= prefixSum[i] + targetSum
                int currentTarget = prefixSum[i] + targetSum;

                // 二分查找：在 prefixSum 中找第一个 >= currentTarget 的位置
                int j = Arrays.binarySearch(prefixSum, currentTarget);
                if (j < 0) {
                    j = -j - 1; // 如果没找到，返回插入点
                }

                // 如果找到合法的 j，更新最小长度
                if (j <= n) {
                    minLength = Math.min(minLength, j - i);
                }
            }

            return minLength == Integer.MAX_VALUE ? 0 : minLength;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
