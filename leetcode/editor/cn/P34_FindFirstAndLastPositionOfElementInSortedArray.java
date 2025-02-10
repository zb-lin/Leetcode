//给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。请你找出给定目标值在数组中的开始位置和结束位置。 
//
// 如果数组中不存在目标值 target，返回 [-1, -1]。 
//
// 你必须设计并实现时间复杂度为 O(log n) 的算法解决此问题。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [5,7,7,8,8,10], target = 8
//输出：[3,4] 
//
// 示例 2： 
//
// 
//输入：nums = [5,7,7,8,8,10], target = 6
//输出：[-1,-1] 
//
// 示例 3： 
//
// 
//输入：nums = [], target = 0
//输出：[-1,-1] 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 10⁵ 
// -10⁹ <= nums[i] <= 10⁹ 
// nums 是一个非递减数组 
// -10⁹ <= target <= 10⁹ 
// 
//
// Related Topics 数组 二分查找 👍 2710 👎 0


package leetcode.editor.cn;

/**
 * 在排序数组中查找元素的第一个和最后一个位置
 *
 * @author lzb
 * @date 2024-06-10 21:11:50
 */
public class P34_FindFirstAndLastPositionOfElementInSortedArray {
    public static void main(String[] args) {
        Solution solution = new P34_FindFirstAndLastPositionOfElementInSortedArray().new Solution();
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] searchRange(int[] nums, int target) {
            // 找到第一个目标值
            int start = binarySearch(nums, target);
            if (start == nums.length || nums[start] != target) {
                return new int[]{-1, -1};
            }
            // 找到第一个比目标值大的元素
            int end = binarySearch(nums, target + 1) - 1;
            return new int[]{start, end};
        }

        public int binarySearch(int[] nums, int target) {
            int n = nums.length;
            int left = 0, right = n - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] < target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            return left;
        }



        /*public int[] searchRange(int[] nums, int target) {
            int n = nums.length;
            // 先用二分查找找出一个目标值
            int left = 0, right = n - 1, index = -1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] == target) {
                    index = mid;
                    // 找到目标元素马上退出
                    break;
                } else if (nums[mid] < target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            // 找不到目标值返回{-1, -1}
            if (index == -1) return new int[]{-1, -1};
            // 从该位置向左向右查找
            left = index;
            right = index;
            while (left - 1 >= 0 && nums[left - 1] == target) {
                left--;
            }
            while (right + 1 < n && nums[right + 1] == target) {
                right++;
            }
            return new int[]{left, right};
        }*/
    }
//leetcode submit region end(Prohibit modification and deletion)

}
