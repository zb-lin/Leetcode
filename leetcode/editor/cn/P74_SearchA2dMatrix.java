//给你一个满足下述两条属性的 m x n 整数矩阵： 
//
// 
// 每行中的整数从左到右按非严格递增顺序排列。 
// 每行的第一个整数大于前一行的最后一个整数。 
// 
//
// 给你一个整数 target ，如果 target 在矩阵中，返回 true ；否则，返回 false 。 
//
// 
//
// 示例 1： 
// 
// 
//输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
//输出：true
// 
//
// 示例 2： 
// 
// 
//输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 100 
// -10⁴ <= matrix[i][j], target <= 10⁴ 
// 
//
// Related Topics 数组 二分查找 矩阵 👍 926 👎 0


package leetcode.editor.cn;

/**
 * 搜索二维矩阵
 *
 * @author lzb
 * @date 2024-05-26 15:49:27
 */
public class P74_SearchA2dMatrix {
    public static void main(String[] args) {
        Solution solution = new P74_SearchA2dMatrix().new Solution();
        int[][] matrix = {
                {1, 3}
        };
        solution.searchMatrix(matrix, 3);
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean searchMatrix(int[][] matrix, int target) {
            for (int[] matrixArray : matrix) {
                if (target < matrixArray[0]) return false;
                int n = matrixArray.length;
                int left = 0, right = n - 1;
                while (left <= right) {
                    int mid = (right + left + 1) / 2;
                    if (matrixArray[mid] == target) {
                        return true;
                    } else if (matrixArray[mid] < target) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
