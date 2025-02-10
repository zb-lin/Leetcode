//给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。 
//
// 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。 
//
// 你必须设计并实现时间复杂度为 O(n) 的算法解决此问题。 
//
// 
//
// 示例 1: 
//
// 
//输入: [3,2,1,5,6,4], k = 2
//输出: 5
// 
//
// 示例 2: 
//
// 
//输入: [3,2,3,1,2,4,5,5,6], k = 4
//输出: 4 
//
// 
//
// 提示： 
//
// 
// 1 <= k <= nums.length <= 10⁵ 
// -10⁴ <= nums[i] <= 10⁴ 
// 
//
// Related Topics 数组 分治 快速选择 排序 堆（优先队列） 👍 2471 👎 0


package leetcode.editor.cn;

import java.util.PriorityQueue;

/**
 * 数组中的第K个最大元素
 *
 * @author lzb
 * @date 2024-05-27 21:23:25
 */
public class P215_KthLargestElementInAnArray {
    public static void main(String[] args) {
        Solution solution = new P215_KthLargestElementInAnArray().new Solution();
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findKthLargest(int[] nums, int k) {
            return quickSort(nums, 0, nums.length - 1, nums.length - k);
        }

        public int quickSort(int[] nums, int left, int right, int k) {
            if (left == right) return nums[k];
            int partition = nums[left], less = left - 1, more = right + 1;
            while (less < more) {
                do {
                    less++;
                } while (nums[less] < partition);
                do {
                    more--;
                } while (nums[more] > partition);
                if (less < more) {
                    swap(nums, less, more);
                }
            }
            if (k <= more) {
                return quickSort(nums, left, more, k);
            } else {
                return quickSort(nums, more + 1, right, k);
            }
        }

        public void swap(int[] nums, int i, int j) {
            if (i == j) return;
            nums[i] = nums[i] ^ nums[j];
            nums[j] = nums[i] ^ nums[j];
            nums[i] = nums[i] ^ nums[j];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
