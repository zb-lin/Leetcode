//给你一个整数数组 arr 和一个整数 difference，请你找出并返回 arr 中最长等差子序列的长度，该子序列中相邻元素之间的差等于 
//difference 。 
//
// 子序列 是指在不改变其余元素顺序的情况下，通过删除一些元素或不删除任何元素而从 arr 派生出来的序列。 
//
// 
//
// 示例 1： 
//
// 
//输入：arr = [1,2,3,4], difference = 1
//输出：4
//解释：最长的等差子序列是 [1,2,3,4]。 
//
// 示例 2： 
//
// 
//输入：arr = [1,3,5,7], difference = 1
//输出：1
//解释：最长的等差子序列是任意单个元素。
// 
//
// 示例 3： 
//
// 
//输入：arr = [1,5,7,8,5,3,4,2,1], difference = -2
//输出：4
//解释：最长的等差子序列是 [7,5,3,1]。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= arr.length <= 10⁵ 
// -10⁴ <= arr[i], difference <= 10⁴ 
// 
//
// Related Topics 数组 哈希表 动态规划 👍 299 👎 0


package leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 最长定差子序列
 *
 * @author lzb
 * @date 2024-09-19 18:35:40
 */
public class P1218_LongestArithmeticSubsequenceOfGivenDifference {
    public static void main(String[] args) {
        Solution solution = new P1218_LongestArithmeticSubsequenceOfGivenDifference().new Solution();
        int[] arr = {4, 12, 10, 0, -2, 7, -8, 9, -9, -12, -12, 8, 8};
        solution.longestSubsequence(arr, 0);
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int longestSubsequence(int[] arr, int difference) {
            int n = arr.length;
            Map<Integer, Integer> idxMap = new HashMap<>();
            for (int i = 0; i < n; ++i) {
                idxMap.put(arr[i], i);
            }
            int[] dp = new int[n];
            int res = 0;
            for (int i = 0; i < n; ++i) {
                dp[i] = idxMap.containsKey(arr[i] - difference) ? dp[idxMap.get(arr[i] - difference)] + 1 : 1;
                res = Math.max(res, dp[i]);
            }
            System.out.println(Arrays.toString(dp));
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
