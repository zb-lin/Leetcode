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
        /**
         * 查找数组中第k大的元素
         * @param nums 输入数组
         * @param k 第k大的位置
         * @return 第k大的元素值
         */
        public int findKthLargest(int[] nums, int k) {
            // 将问题转换为查找第(nums.length - k)小的元素
            // 例如：第2大的元素就是第(nums.length - 2)小的元素
            return quickSelect(nums, 0, nums.length - 1, nums.length - k);
        }

        /**
         * 快速选择算法实现
         * @param nums 输入数组
         * @param left 当前处理区间的左边界
         * @param right 当前处理区间的右边界
         * @param k 要查找的第k小的元素位置
         * @return 第k小的元素值
         */
        private int quickSelect(int[] nums, int left, int right, int k) {
            if (left >= right) return nums[left];
            int pivotIndex = (int) (Math.random() * (right - left + 1)) + left;
            int pivot = nums[pivotIndex];
            swap(nums, left, pivotIndex);
            int i = left + 1, lt = left, gt = right;

            // 三路分区：将数组分为 <pivot, ==pivot, >pivot 三部分
            while (i <= gt) {
                if (nums[i] < pivot) {
                    swap(nums, i++, lt++);
                } else if (nums[i] > pivot) {
                    swap(nums, i, gt--);
                } else  {
                    i++;
                }
            }
            // 根据k的位置决定递归处理哪一部分
            if (k < lt) {
                return quickSelect(nums, left, lt - 1, k);
            } else if (k > gt) {
                return quickSelect(nums, gt + 1, right, k);
            } else {
                return nums[k]; // k在等于pivot的区间内，直接返回
            }
        }

        /**
         * 交换数组中两个元素的位置
         * @param nums 输入数组
         * @param i 第一个元素的索引
         * @param j 第二个元素的索引
         */
        private void swap(int[] nums, int i, int j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }

        // public int quickQuery(int[] nums, int left, int right, int k) {
        //     if (left >= right) return nums[left];
        //     int random = (int)(Math.random() * (right - left + 1)) + left;
        //     swap(nums, random, left);
        //     int pivot = nums[left];
        //     int lt = left;
        //     int gt = right;
        //     int i = left + 1;
        //     while (i <= gt) {
        //         if (nums[i] < pivot) {
        //             swap(nums, i++, lt++);
        //         } else if (nums[i] > pivot) {
        //             swap(nums, i, gt--);
        //         } else {
        //             i++;
        //         }
        //     }

        //     if (k < lt) {
        //         return quickQuery(nums, left, lt - 1, k);
        //     } else if (k > gt) {
        //         return quickQuery(nums, gt + 1, right, k);
        //     } else {
        //         return nums[k];
        //     }
        // }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
