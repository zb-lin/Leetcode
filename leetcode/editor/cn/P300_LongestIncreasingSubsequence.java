//给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
//
// 子序列 是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子
//序列。
//
// 示例 1：
//
//
//输入：nums = [10,9,2,5,3,7,101,18]
//输出：4
//解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。
//
//
// 示例 2：
//
//
//输入：nums = [0,1,0,3,2,3]
//输出：4
//
//
// 示例 3：
//
//
//输入：nums = [7,7,7,7,7,7,7]
//输出：1
//
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 2500
// -10⁴ <= nums[i] <= 10⁴
//
//
//
//
// 进阶：
//
//
// 你能将算法的时间复杂度降低到 O(n log(n)) 吗?
//
//
// Related Topics 数组 二分查找 动态规划 👍 3652 👎 0


package leetcode.editor.cn;

/**
 * 最长递增子序列
 *
 * @author lzb
 * @date 2024-06-11 11:31:10
 */
public class P300_LongestIncreasingSubsequence {
    public static void main(String[] args) {
        Solution solution = new P300_LongestIncreasingSubsequence().new Solution();
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int lengthOfLIS(int[] nums) {
            // tails数组：tails[i]表示长度为i+1的递增子序列的最小末尾元素
            int[] tails = new int[nums.length];
            int size = 0;
            for (int num : nums) {
                int left = 0, right = size;
                // 找到第一个大于等于num的元素位置
                while (left < right) {
                    int mid = left + (right - left) / 2;
                    if (tails[mid] < num) {
                        left = mid + 1;
                    } else {
                        right = mid;
                    }
                }
//                假设当前tails = [2,5,7]，size=3：
//                遇到数字3：
//                通过二分查找确定应该替换tails[1]=5
//                更新后tails = [2,3,7]（优化了长度为2的子序列末尾）
//                遇到数字8：
//                可以扩展size，得到tails = [2,3,7,8]
                tails[left] = num;
                if (left == size) {
                    size++;
                }
            }
            return size;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
