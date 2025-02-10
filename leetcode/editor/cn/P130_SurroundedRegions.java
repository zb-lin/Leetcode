//给你一个 m x n 的矩阵 board ，由若干字符 'X' 和 'O' 组成，捕获 所有 被围绕的区域： 
//
// 
// 连接：一个单元格与水平或垂直方向上相邻的单元格连接。 
// 区域：连接所有 'O' 的单元格来形成一个区域。 
// 围绕：如果您可以用 'X' 单元格 连接这个区域，并且区域中没有任何单元格位于 board 边缘，则该区域被 'X' 单元格围绕。 
// 
//
// 通过将输入矩阵 board 中的所有 'O' 替换为 'X' 来 捕获被围绕的区域。 
//
// 
// 
// 
// 
// 
//
// 示例 1： 
//
// 
// 输入：board = [["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O",
//"X","X"]] 
// 
//
// 输出：[["X","X","X","X"],["X","X","X","X"],["X","X","X","X"],["X","O","X","X"]] 
//
//
// 解释： 
// 
// 在上图中，底部的区域没有被捕获，因为它在 board 的边缘并且不能被围绕。 
//
// 示例 2： 
//
// 
// 输入：board = [["X"]] 
// 
//
// 输出：[["X"]] 
//
// 
//
// 提示： 
//
// 
// m == board.length 
// n == board[i].length 
// 1 <= m, n <= 200 
// board[i][j] 为 'X' 或 'O' 
// 
//
// Related Topics 深度优先搜索 广度优先搜索 并查集 数组 矩阵 👍 1154 👎 0


package leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;

/**
 * 被围绕的区域
 *
 * @author lzb
 * @date 2024-10-10 20:29:50
 */
public class P130_SurroundedRegions {
    public static void main(String[] args) {
        Solution solution = new P130_SurroundedRegions().new Solution();
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        Set<Character> record = new HashSet<>();

        public void solve(char[][] board) {
            char sign = '1';
            for (int row = 0; row < board.length; row++) {
                for (int col = 0; col < board[row].length; col++) {
                    if (board[row][col] == 'O') {
                        dfs(board, row, col, sign);
                        sign++;
                    }
                }
            }
            for (int row = 0; row < board.length; row++) {
                for (int col = 0; col < board[row].length; col++) {
                    if (!record.contains(board[row][col])) {
                        board[row][col] = 'X';
                    } else {
                        board[row][col] = 'O';
                    }
                }
            }
        }

        public void dfs(char[][] board, int row, int col, char sign) {
            if (row >= board.length || row < 0 || col < 0 || col >= board[0].length) return;
            if (board[row][col] != 'O') return;
            if (row == board.length - 1 || row == 0 || col == board[0].length - 1 || col == 0) record.add(sign);
            board[row][col] = sign;
            dfs(board, row - 1, col, sign);
            dfs(board, row, col - 1, sign);
            dfs(board, row + 1, col, sign);
            dfs(board, row, col + 1, sign);
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
