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
            int[] pre = new int[n + 1];
            int minLen = n + 1;
            for (int i = 1; i <= n; ++i) {
                pre[i] = pre[i - 1] + nums[i - 1];
            }
            for (int j = 0; j < n; ++j) {
                int i = binarySearch(pre, 0, j, pre[j + 1] - target);
                if (i != -1) {
                    minLen = Math.min(minLen, j - i + 1);
                }
            }
            return minLen == n + 1 ? 0 : minLen;
        }

        public int binarySearch(int[] nums, int left, int right, int target) {
            if (target < 0) return -1;
            while (left < right) {
                int mid = (left + right + 1) / 2;
                if (nums[mid] <= target) {
                    left = mid;
                } else {
                    right = mid - 1;
                }
            }
            if (nums[left] > target) return -1;
            return left;
        }
    /*    public int minSubArrayLen(int target, int[] nums) {
            int n = nums.length;
            int sum = 0, left = 0, res = Integer.MAX_VALUE;
            for (int right = 0; right < n; right++) {
                sum += nums[right];
                while (sum >= target) {
                    res = Math.min(res, right - left + 1);
                    sum -= nums[left++];
                }
            }
            return res == Integer.MAX_VALUE ? 0 : res;
        }*/
    }
//leetcode submit region end(Prohibit modification and deletion)

}
