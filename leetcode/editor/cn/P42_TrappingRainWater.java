//给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
//输出：6
//解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 
// 
//
// 示例 2： 
//
// 
//输入：height = [4,2,0,3,2,5]
//输出：9
// 
//
// 
//
// 提示： 
//
// 
// n == height.length 
// 1 <= n <= 2 * 10⁴ 
// 0 <= height[i] <= 10⁵ 
// 
//
// Related Topics 栈 数组 双指针 动态规划 单调栈 👍 5185 👎 0


package leetcode.editor.cn;

/**
 * 接雨水
 *
 * @author lzb
 * @date 2024-06-10 21:15:28
 */
public class P42_TrappingRainWater {
    public static void main(String[] args) {
        Solution solution = new P42_TrappingRainWater().new Solution();
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int trap(int[] height) {
            int n = height.length;
            int[] leftHeight = new int[n];
            int[] rightHeight = new int[n];
            leftHeight[0] = height[0];
            rightHeight[n - 1] = height[n - 1];
            for (int i = 1; i < n; ++i) {
                leftHeight[i] = Math.max(leftHeight[i - 1], height[i]);
            }
            for (int i = n - 2; i >= 0; --i) {
                rightHeight[i] = Math.max(rightHeight[i + 1], height[i]);
            }
            int ans = 0;
            for (int i = 0; i < n; ++i) {
                ans += Math.min(leftHeight[i], rightHeight[i]) - height[i];
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
