//给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。 
//
// 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [-4,-1,0,3,10]
//输出：[0,1,9,16,100]
//解释：平方后，数组变为 [16,1,0,9,100]
//排序后，数组变为 [0,1,9,16,100] 
//
// 示例 2： 
//
// 
//输入：nums = [-7,-3,2,3,11]
//输出：[4,9,9,49,121]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁴ 
// -10⁴ <= nums[i] <= 10⁴ 
// nums 已按 非递减顺序 排序 
// 
//
// 
//
// 进阶： 
//
// 
// 请你设计时间复杂度为 O(n) 的算法解决本问题 
// 
//
// Related Topics 数组 双指针 排序 👍 995 👎 0


package leetcode.editor.cn;

/**
 * 有序数组的平方
 *
 * @author lzb
 * @date 2024-06-18 21:38:25
 */
public class P977_SquaresOfASortedArray {
    public static void main(String[] args) {
        Solution solution = new P977_SquaresOfASortedArray().new Solution();
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] sortedSquares(int[] nums) {
            int n = nums.length;
            int[] res = new int[n];
            int left = 0, right = n - 1;
            // 双指针比较, 从后向前填充
            for (int i = n - 1; i >= 0; i--) {
                int leftNum = nums[left] * nums[left];
                int rightNum = nums[right] * nums[right];
                if (leftNum > rightNum) {
                    res[i] = leftNum;
                    left++;
                } else {
                    res[i] = rightNum;
                    right--;
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
