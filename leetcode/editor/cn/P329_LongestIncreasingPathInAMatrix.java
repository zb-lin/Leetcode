//给定一个 m x n 整数矩阵 matrix ，找出其中 最长递增路径 的长度。 
//
// 对于每个单元格，你可以往上，下，左，右四个方向移动。 你 不能 在 对角线 方向上移动或移动到 边界外（即不允许环绕）。 
//
// 
//
// 示例 1： 
// 
// 
//输入：matrix = [[9,9,4],[6,6,8],[2,1,1]]
//输出：4 
//解释：最长递增路径为 [1, 2, 6, 9]。 
//
// 示例 2： 
// 
// 
//输入：matrix = [[3,4,5],[3,2,6],[2,2,1]]
//输出：4 
//解释：最长递增路径是 [3, 4, 5, 6]。注意不允许在对角线方向上移动。
// 
//
// 示例 3： 
//
// 
//输入：matrix = [[1]]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 200 
// 0 <= matrix[i][j] <= 2³¹ - 1 
// 
//
// Related Topics 深度优先搜索 广度优先搜索 图 拓扑排序 记忆化搜索 数组 动态规划 矩阵 👍 860 👎 0


package leetcode.editor.cn;

/**
 * 矩阵中的最长递增路径
 *
 * @author lzb
 * @date 2024-09-12 22:41:27
 */
public class P329_LongestIncreasingPathInAMatrix {
    public static void main(String[] args) {
        Solution solution = new P329_LongestIncreasingPathInAMatrix().new Solution();
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        public int rows, columns;

        public int longestIncreasingPath(int[][] matrix) {
            if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
                return 0;
            }
            rows = matrix.length;
            columns = matrix[0].length;
            int[][] memo = new int[rows][columns];
            int ans = 0;
            for (int i = 0; i < rows; ++i) {
                for (int j = 0; j < columns; ++j) {
                    ans = Math.max(ans, dfs(matrix, i, j, memo));
                }
            }
            return ans;
        }

        public int dfs(int[][] matrix, int row, int column, int[][] memo) {
            if (memo[row][column] != 0) {
                return memo[row][column];
            }
            ++memo[row][column];
            for (int[] dir : dirs) {
                int newRow = row + dir[0], newColumn = column + dir[1];
                if (newRow >= 0 && newRow < rows && newColumn >= 0 && newColumn < columns && matrix[newRow][newColumn] > matrix[row][column]) {
                    memo[row][column] = Math.max(memo[row][column], dfs(matrix, newRow, newColumn, memo) + 1);
                }
            }
            return memo[row][column];
        }

        /*boolean[][] visited;
        int maxLen = Integer.MIN_VALUE;


        public int longestIncreasingPath(int[][] matrix) {
            int m = matrix.length, n = matrix[0].length;
            visited = new boolean[m][n];
            for (int i = 0; i < m; ++i) {
                for (int j = 0; j < n; ++j) {
                    backtrack(matrix, i, j, 1);
                }
            }
            return maxLen;
        }

        public void backtrack(int[][] matrix, int row, int col, int len) {
            visited[row][col] = true;
            maxLen = Math.max(maxLen, len);
            if (row > 0 && !visited[row - 1][col] && matrix[row - 1][col] > matrix[row][col]) {
                backtrack(matrix, row - 1, col, len + 1);
            }
            if (col > 0 && !visited[row][col - 1] && matrix[row][col - 1] > matrix[row][col]) {
                backtrack(matrix, row, col - 1, len + 1);
            }
            if (row < matrix.length - 1 && !visited[row + 1][col] && matrix[row + 1][col] > matrix[row][col]) {
                backtrack(matrix, row + 1, col, len + 1);
            }
            if (col < matrix[0].length - 1 && !visited[row][col + 1] && matrix[row][col + 1] > matrix[row][col]) {
                backtrack(matrix, row, col + 1, len + 1);
            }
            visited[row][col] = false;
        }*/
    }
//leetcode submit region end(Prohibit modification and deletion)

}
