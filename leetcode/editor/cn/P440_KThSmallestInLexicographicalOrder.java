//给定整数 n 和 k，返回 [1, n] 中字典序第 k 小的数字。 
//
// 
//
// 示例 1: 
//
// 
//输入: n = 13, k = 2
//输出: 10
//解释: 字典序的排列是 [1, 10, 11, 12, 13, 2, 3, 4, 5, 6, 7, 8, 9]，所以第二小的数字是 10。
// 
//
// 示例 2: 
//
// 
//输入: n = 1, k = 1
//输出: 1
// 
//
// 
//
// 提示: 
//
// 
// 1 <= k <= n <= 10⁹ 
// 
//
// Related Topics 字典树 👍 590 👎 0


package leetcode.editor.cn;

/**
 * 字典序的第K小数字
 *
 * @author lzb
 * @date 2024-09-09 15:39:15
 */
public class P440_KThSmallestInLexicographicalOrder {
    public static void main(String[] args) {
        Solution solution = new P440_KThSmallestInLexicographicalOrder().new Solution();
        System.out.println(solution.findKthNumber(13, 2));
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findKthNumber(int n, int k) {
            int curr = 1;
            k--;
            while (k > 0) {
                int steps = getSteps(curr, n);
                if (steps <= k) {
                    curr++;
                    k -= steps;
                } else {
                    k--;
                    curr *= 10;
                }
            }
            return curr;
        }

        public int getSteps(int curr, int n) {
            long first = curr;
            long last = curr;
            int steps = 0;
            while (first <= n) {
                steps += Math.min(n, last) - first + 1;
                first *= 10;
                last = last * 10 + 9;
            }
            return steps;
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}
