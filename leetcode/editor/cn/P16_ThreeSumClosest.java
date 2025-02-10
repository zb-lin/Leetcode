//给你一个长度为 n 的整数数组 nums 和 一个目标值 target。请你从 nums 中选出三个整数，使它们的和与 target 最接近。 
//
// 返回这三个数的和。 
//
// 假定每组输入只存在恰好一个解。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [-1,2,1,-4], target = 1
//输出：2
//解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,0,0], target = 1
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 3 <= nums.length <= 1000 
// -1000 <= nums[i] <= 1000 
// -10⁴ <= target <= 10⁴ 
// 
//
// Related Topics 数组 双指针 排序 👍 1623 👎 0


package leetcode.editor.cn;

import java.util.Arrays;

/**
 * 最接近的三数之和
 *
 * @author lzb
 * @date 2024-05-23 15:42:48
 */
public class P16_ThreeSumClosest {
    public static void main(String[] args) {
        Solution solution = new P16_ThreeSumClosest().new Solution();
        int[] nums = {-1, 2, 1, -4};
        int target = 1;
        solution.threeSumClosest(nums, target);
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int threeSumClosest(int[] nums, int target) {
            int n = nums.length;
            Arrays.sort(nums);
            int res = Integer.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                int left = i + 1, right = n - 1;
                while (left < right) {
                    int num = nums[i] + nums[left] + nums[right];
                    if (num == target) {
                        return target;
                    }
                    if (Math.abs(target - res) > Math.abs(target - num)) {
                        res = num;
                    }
                    if (num < target) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
