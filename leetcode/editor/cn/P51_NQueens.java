//按照国际象棋的规则，皇后可以攻击与之处在同一行或同一列或同一斜线上的棋子。 
//
// n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。 
//
// 给你一个整数 n ，返回所有不同的 n 皇后问题 的解决方案。 
//
// 
// 
// 每一种解法包含一个不同的 n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。 
// 
// 
//
// 
//
// 示例 1： 
// 
// 
//输入：n = 4
//输出：[[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
//解释：如上图所示，4 皇后问题存在两个不同的解法。
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：[["Q"]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 9 
// 
//
// Related Topics 数组 回溯 👍 2088 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * N 皇后
 *
 * @author lzb
 * @date 2024-06-29 00:31:43
 */
public class P51_NQueens {
    public static void main(String[] args) {
        Solution solution = new P51_NQueens().new Solution();
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<List<String>> res = new ArrayList<>();

        public List<List<String>> solveNQueens(int n) {
            char[][] chessboard = new char[n][n];
            for (char[] chess : chessboard) {
                Arrays.fill(chess, '.');
            }
            backtrack(0, chessboard);
            return res;
        }

        public void backtrack(int row, char[][] chessboard) {
            if (row == chessboard.length) {
                res.add(getItemList(chessboard));
                return;
            }
            for (int col = 0; col < chessboard.length; col++) {
                if (check(chessboard, row, col)) {
                    chessboard[row][col] = 'Q';
                    backtrack(row + 1, chessboard);
                    chessboard[row][col] = '.';
                }
            }
        }

        public List<String> getItemList(char[][] chessboard) {
            List<String> list = new ArrayList<>();
            for (char[] chars : chessboard) {
                list.add(String.copyValueOf(chars));
            }
            return list;
        }

        public boolean check(char[][] chessboard, int row, int col) {
            for (int i = 0; i < row; i++) {
                if (chessboard[i][col] == 'Q') {
                    return false;
                }
            }
            for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
                if (chessboard[i][j] == 'Q') {
                    return false;
                }
            }
            for (int i = row - 1, j = col + 1; i >= 0 && j < chessboard.length; i--, j++) {
                if (chessboard[i][j] == 'Q') {
                    return false;
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
