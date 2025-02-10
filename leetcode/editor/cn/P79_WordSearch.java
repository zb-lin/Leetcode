//给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。 
//
// 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。 
//
// 
//
// 示例 1： 
// 
// 
//输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = 
//"ABCCED"
//输出：true
// 
//
// 示例 2： 
// 
// 
//输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = 
//"SEE"
//输出：true
// 
//
// 示例 3： 
// 
// 
//输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = 
//"ABCB"
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// m == board.length 
// n = board[i].length 
// 1 <= m, n <= 6 
// 1 <= word.length <= 15 
// board 和 word 仅由大小写英文字母组成 
// 
//
// 
//
// 进阶：你可以使用搜索剪枝的技术来优化解决方案，使其在 board 更大的情况下可以更快解决问题？ 
//
// Related Topics 数组 字符串 回溯 矩阵 👍 1827 👎 0


package leetcode.editor.cn;

/**
 * 单词搜索
 *
 * @author lzb
 * @date 2024-06-10 21:58:53
 */
public class P79_WordSearch {
    public static void main(String[] args) {
        Solution solution = new P79_WordSearch().new Solution();
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        boolean[][] flag;

        public boolean exist(char[][] board, String word) {
            char[] wordArray = word.toCharArray();
            flag = new boolean[board.length][board[0].length];
            int index = 0;
            for (int i = 0; i < board.length; ++i) {
                for (int j = 0; j < board[i].length; ++j) {
                    if (board[i][j] == wordArray[0]) {
                        if (index == wordArray.length - 1) return true;
                        if (exist(board, wordArray, i, j, index + 1)) {
                            return true;
                        }
                    }
                }
            }
            return false;
        }



        public boolean exist(char[][] board, char[] wordArray, int i, int j, int index) {
            flag[i][j] = true;
            if (i - 1 >= 0 && !flag[i - 1][j] && board[i - 1][j] == wordArray[index]) {
                if (index == wordArray.length - 1) return true;
                if (exist(board, wordArray, i - 1, j, index + 1)) return true;
            }
            if (j - 1 >= 0 && !flag[i][j - 1] && board[i][j - 1] == wordArray[index]) {
                if (index == wordArray.length - 1) return true;
                if (exist(board, wordArray, i, j - 1, index + 1)) return true;
            }
            if (j + 1 < board[0].length && !flag[i][j + 1] && board[i][j + 1] == wordArray[index]) {
                if (index == wordArray.length - 1) return true;
                if (exist(board, wordArray, i, j + 1, index + 1)) return true;
            }
            if (i + 1 < board.length && !flag[i + 1][j] && board[i + 1][j] == wordArray[index]) {
                if (index == wordArray.length - 1) return true;
                if (exist(board, wordArray, i + 1, j, index + 1)) return true;
            }
            flag[i][j] = false;
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
