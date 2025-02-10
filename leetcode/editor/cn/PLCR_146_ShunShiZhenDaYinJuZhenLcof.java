//给定一个二维数组 array，请返回「螺旋遍历」该数组的结果。 
//
// 螺旋遍历：从左上角开始，按照 向右、向下、向左、向上 的顺序 依次 提取元素，然后再进入内部一层重复相同的步骤，直到提取完所有元素。 
//
// 
//
// 示例 1： 
//
// 
//输入：array = [[1,2,3],[8,9,4],[7,6,5]]
//输出：[1,2,3,4,5,6,7,8,9]
// 
//
// 示例 2： 
//
// 
//输入：array  = [[1,2,3,4],[12,13,14,5],[11,16,15,6],[10,9,8,7]]
//输出：[1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16]
// 
//
// 
//
// 限制： 
//
// 
// 0 <= array.length <= 100 
// 0 <= array[i].length <= 100 
// 
//
// 注意：本题与主站 54 题相同：https://leetcode-cn.com/problems/spiral-matrix/ 
//
// 
//
// Related Topics 数组 矩阵 模拟 👍 602 👎 0


package leetcode.editor.cn;

/**
 * 螺旋遍历二维数组
 * @author lzb
 * @date 2024-06-19 15:21:24
 */
public class PLCR_146_ShunShiZhenDaYinJuZhenLcof{
	 public static void main(String[] args) {
	 	 Solution solution = new PLCR_146_ShunShiZhenDaYinJuZhenLcof().new Solution();
	 }


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] spiralArray(int[][] array) {
		int n = array.length;
		if (n == 0) return new int[]{};
		int m = array[0].length;
		int[] res = new int[n * m];
		// 上下边界
		int up = 0, low = n - 1;
		// 左右边界
		int left = 0, right = m - 1;
		// 该填入的值
		int index = 0;
		while (index < n * m) {
			if (up <= low) {
				// 上边界从左往右
				for (int j = left; j <= right; j++) {
					res[index++] = array[up][j];
				}
				up++;
			}
			if (left <= right) {
				// 右边界从上到下
				for (int i = up; i <= low; i++) {
					res[index++] = array[i][right];
				}
				right--;
			}
			if (up <= low) {
				// 下边界从右往左
				for (int j = right; j >= left; j--) {
					res[index++] = array[low][j];
				}
				low--;
			}
			if (left <= right) {
				// 左边界从下到上
				for (int i = low; i >= up; i--) {
					res[index++] = array[i][left];
				}
				left++;
			}
		}
		return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
