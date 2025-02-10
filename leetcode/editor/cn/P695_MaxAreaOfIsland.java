//给你一个大小为 m x n 的二进制矩阵 grid 。 
//
// 岛屿 是由一些相邻的 1 (代表土地) 构成的组合，这里的「相邻」要求两个 1 必须在 水平或者竖直的四个方向上 相邻。你可以假设 grid 的四个边缘都
//被 0（代表水）包围着。 
//
// 岛屿的面积是岛上值为 1 的单元格的数目。 
//
// 计算并返回 grid 中最大的岛屿面积。如果没有岛屿，则返回面积为 0 。 
//
// 
//
// 示例 1： 
// 
// 
//输入：grid = [[0,0,1,0,0,0,0,1,0,0,0,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,1,1,0,1,
//0,0,0,0,0,0,0,0],[0,1,0,0,1,1,0,0,1,0,1,0,0],[0,1,0,0,1,1,0,0,1,1,1,0,0],[0,0,0,
//0,0,0,0,0,0,0,1,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,0,0,0,0,0,0,1,1,0,0,0,0]]
//输出：6
//解释：答案不应该是 11 ，因为岛屿只能包含水平或垂直这四个方向上的 1 。
// 
//
// 示例 2： 
//
// 
//输入：grid = [[0,0,0,0,0,0,0,0]]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 50 
// grid[i][j] 为 0 或 1 
// 
//
// Related Topics 深度优先搜索 广度优先搜索 并查集 数组 矩阵 👍 1087 👎 0


package leetcode.editor.cn;

/**
 * 岛屿的最大面积
 *
 * @author lzb
 * @date 2024-09-05 13:05:13
 */
public class P695_MaxAreaOfIsland {
    public static void main(String[] args) {
        Solution solution = new P695_MaxAreaOfIsland().new Solution();
        int[][] grid = {
                {0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}
        };
        solution.maxAreaOfIsland(grid);
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        boolean[][] visited;
        int maxArea = 0;
        int currArea;

        public int maxAreaOfIsland(int[][] grid) {
            visited = new boolean[grid.length][grid[0].length];
            for (int i = 0; i < grid.length; ++i) {
                for (int j = 0; j < grid[0].length; ++j) {
                    if (visited[i][j]) continue;
                    if (grid[i][j] == 1) {
                        currArea = 0;
                        visit(grid, i, j);
                    }
                }
            }
            return maxArea;
        }

        public void visit(int[][] grid, int row, int col) {
            if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length) return;
            if (visited[row][col] || grid[row][col] == 0) return;
            currArea++;
            maxArea = Math.max(maxArea, currArea);
            visited[row][col] = true;
            visit(grid, row + 1, col);
            visit(grid, row - 1, col);
            visit(grid, row, col + 1);
            visit(grid, row, col - 1);

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
