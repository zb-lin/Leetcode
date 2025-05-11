//给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。 
//
// 
//
// 示例 1： 
// 
// 
//输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
//输出：[1,2,3,6,9,8,7,4,5]
// 
//
// 示例 2： 
// 
// 
//输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
//输出：[1,2,3,4,8,12,11,10,9,5,6,7]
// 
//
// 
//
// 提示： 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 10 
// -100 <= matrix[i][j] <= 100 
// 
//
// Related Topics 数组 矩阵 模拟 👍 1696 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 螺旋矩阵
 *
 * @author lzb
 * @date 2024-06-11 11:06:25
 */
public class P54_SpiralMatrix {
    public static void main(String[] args) {
        Solution solution = new P54_SpiralMatrix().new Solution();
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> spiralOrder(int[][] matrix) {
            List<Integer> res = new ArrayList<>();
            int m = matrix.length, n = matrix[0].length, size = m * n;
            int up = 0, low = m - 1, left = 0, right = n - 1;
            while (res.size() < size) {
                if (up <= low) {
                    for (int col = left; col <= right; ++col) {
                        res.add(matrix[up][col]);
                    }
                    up++;
                }
                if (left <= right) {
                    for (int row = up; row <= low; ++row) {
                        res.add(matrix[row][right]);
                    }
                    right--;
                }
                if (up <= low) {
                    for (int col = right; col >= left; --col) {
                        res.add(matrix[low][col]);
                    }
                    low--;
                }
                if (left <= right) {
                    for (int row = low; row >= up; --row) {
                        res.add(matrix[row][left]);
                    }
                    left++;
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
