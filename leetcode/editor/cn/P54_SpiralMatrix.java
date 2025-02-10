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
            PriorityQueue<ListNode> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.val));
            int n = matrix.length, m = matrix[0].length;
            List<Integer> res = new ArrayList<>();
            // 上下边界
            int up = 0, low = n - 1;
            // 左右边界
            int left = 0, right = m - 1;
            // 该填入的值
            while (res.size() < n * m) {
                if (up <= low) {
                    // 上边界从左往右
                    for (int j = left; j <= right; j++) {
                        res.add(matrix[up][j]);
                    }
                    up++;
                }
                if (left <= right) {
                    // 右边界从上到下
                    for (int i = up; i <= low; i++) {
                        res.add(matrix[i][right]);
                    }
                    right--;
                }
                if (up <= low) {
                    // 下边界从右往左
                    for (int j = right; j >= left; j--) {
                        res.add(matrix[low][j]);
                    }
                    low--;
                }
                if (left <= right) {
                    // 左边界从下到上
                    for (int i = low; i >= up; i--) {
                        res.add(matrix[i][left]);
                    }
                    left++;
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
