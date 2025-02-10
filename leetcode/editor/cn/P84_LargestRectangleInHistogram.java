//给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。 
//
// 求在该柱状图中，能够勾勒出来的矩形的最大面积。 
//
// 
//
// 示例 1: 
//
// 
//
// 
//输入：heights = [2,1,5,6,2,3]
//输出：10
//解释：最大的矩形为图中红色区域，面积为 10
// 
//
// 示例 2： 
//
// 
//
// 
//输入： heights = [2,4]
//输出： 4 
//
// 
//
// 提示： 
//
// 
// 1 <= heights.length <=10⁵ 
// 0 <= heights[i] <= 10⁴ 
// 
//
// Related Topics 栈 数组 单调栈 👍 2735 👎 0


package leetcode.editor.cn;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 柱状图中最大的矩形
 *
 * @author lzb
 * @date 2024-06-10 22:01:16
 */
public class P84_LargestRectangleInHistogram {
    public static void main(String[] args) {
        Solution solution = new P84_LargestRectangleInHistogram().new Solution();
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int largestRectangleArea(int[] heights) {
            int n = heights.length;
            int[] left = new int[n];
            int[] right = new int[n];
            Arrays.fill(right, n);
            Deque<Integer> stack = new LinkedList<>();
            for (int i = 0; i < n; ++i) {
                while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                    right[stack.peek()] = i;
                    stack.pop();
                }
                left[i] = (stack.isEmpty() ? -1 : stack.peek());
                stack.push(i);
            }

            int ans = 0;
            for (int i = 0; i < n; ++i) {
                ans = Math.max(ans, (right[i] - left[i] - 1) * heights[i]);
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
