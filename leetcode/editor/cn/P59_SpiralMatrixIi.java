//给你一个正整数 n ，生成一个包含 1 到 n² 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。 
//
// 
//
// 示例 1： 
// 
// 
//输入：n = 3
//输出：[[1,2,3],[8,9,4],[7,6,5]]
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：[[1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 20 
// 
//
// Related Topics 数组 矩阵 模拟 👍 1292 👎 0


package leetcode.editor.cn;

/**
 * 螺旋矩阵 II
 *
 * @author lzb
 * @date 2024-06-19 14:54:02
 */
public class P59_SpiralMatrixIi {
    public static void main(String[] args) {
        Solution solution = new P59_SpiralMatrixIi().new Solution();
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] generateMatrix(int n) {
            int[][] matrix = new int[n][n];
            // 上下边界
            int up = 0, low = n - 1;
            // 左右边界
            int left = 0, right = n - 1;
            // 该填入的值
            int index = 1;
            while (index <= n * n) {
                if (up <= low) {
                    // 上边界从左往右
                    for (int j = left; j <= right; j++) {
                        matrix[up][j] = index++;
                    }
                    up++;
                }
                if (left <= right) {
                    // 右边界从上到下
                    for (int i = up; i <= low; i++) {
                        matrix[i][right] = index++;
                    }
                    right--;
                }
                if (up <= low) {
                    // 下边界从右往左
                    for (int j = right; j >= left; j--) {
                        matrix[low][j] = index++;
                    }
                    low--;
                }
                if (left <= right) {
                    // 左边界从下到上
                    for (int i = low; i >= up; i--) {
                        matrix[i][left] = index++;
                    }
                    left++;
                }
            }
            return matrix;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
