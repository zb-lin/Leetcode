//在一个由 '0' 和 '1' 组成的二维矩阵内，找到只包含 '1' 的最大正方形，并返回其面积。 
//
// 
//
// 示例 1： 
// 
// 
//输入：matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"]
//,["1","0","0","1","0"]]
//输出：4
// 
//
// 示例 2： 
// 
// 
//输入：matrix = [["0","1"],["1","0"]]
//输出：1
// 
//
// 示例 3： 
//
// 
//输入：matrix = [["0"]]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 300 
// matrix[i][j] 为 '0' 或 '1' 
// 
//
// Related Topics 数组 动态规划 矩阵 👍 1663 👎 0


package leetcode.editor.cn;

import java.util.Arrays;

/**
 * 最大正方形
 *
 * @author lzb
 * @date 2024-06-10 22:53:32
 */
public class P221_MaximalSquare {
    public static void main(String[] args) {
        Solution solution = new P221_MaximalSquare().new Solution();
        char[][] matrix = {{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'}, {'1', '1', '1', '1', '1'}, {'1', '0', '0', '1', '0'}};
        solution.maximalSquare(matrix);
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maximalSquare(char[][] matrix) {
            int[][] dp = new int[matrix.length][matrix[0].length];
            int max = 0;
            for (int i = 0; i < matrix.length; ++i) {
                for (int j = 0; j < matrix[i].length; ++j) {
                    int up = i - 1 >= 0 ? dp[i - 1][j] : 0;
                    int left = j - 1 >= 0 ? dp[i][j - 1] : 0;
                    int upLeft = i - 1 >= 0 && j - 1 >= 0 ? dp[i - 1][j - 1] : 0;
                    dp[i][j] = matrix[i][j] == '1' ? Math.min(up, Math.min(left, upLeft)) + 1 : 0;
                    max = Math.max(max, dp[i][j]);
                }
            }
            return max * max;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
