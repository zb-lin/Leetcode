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
            int row = matrix.length, col = matrix[0].length;
            int[][] dp = new int[row][col];
            int max = 0;
            for (int i = 0; i < row; ++i) {
                dp[i][0] = matrix[i][0] - '0';
                if (dp[i][0] == 1) max = 1;
            }
            for (int j = 0; j < col; ++j) {
                dp[0][j] = matrix[0][j] - '0';
                if (dp[0][j] == 1) max = 1;
            }
            for (int i = 1; i < row; ++i) {
                for (int j = 1; j < col; ++j) {
                    if (matrix[i][j] == '1') {
                        int left = dp[i][j - 1];
                        int up = dp[i - 1][j];
                        int left_up = dp[i - 1][j - 1];
                        dp[i][j] = Math.min(Math.min(left, up), left_up) + 1;
                        max = Math.max(max, dp[i][j]);
                    }
                }
            }
            return max * max;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
