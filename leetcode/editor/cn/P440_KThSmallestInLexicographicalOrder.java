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
                // 初始化当前数字为1（字典序最小）
                // 示例：n=13, k=2 → curr=1
                int curr = 1;

                // 因为curr初始是1，相当于已经走过1步，所以k减1
                // 示例：k=2 → k=1
                k--;

                // 当还需要继续找k步时
                while (k > 0) {
                    // 计算以curr为前缀的数字总数（子树大小）
                    // 示例：curr=1 → 计算1,10,11,12,13的数量（共5个）
                    int steps = countSteps(curr, curr + 1, n);

                    if (steps <= k) {
                        // 如果k不在当前前缀的子树中，移动到下一个前缀
                        // 示例：steps=5 > k=1 → 不进入
                        curr++;
                        k -= steps;
                    } else {
                        // 进入当前前缀的子树（下一位）
                        // 示例：curr=1 → curr=10, k=0
                        curr *= 10;
                        k--;
                    }
                }
                // 最终curr就是第k小的数字
                // 示例：curr=10
                return curr;
            }

            // 计算1开头的数字数量（1,10,11,12,13）
            private int countSteps(long first, long last, int n) {
                int steps = 0;
                // 示例：first=1, last=2, n=13
                while (first <= n) {
                    // 当前层的数字数量 = min(n+1, last) - first
                    // 示例：第一层（1）→ min(14,2)-1=1
                    //      第二层（10-13）→ min(14,20)-10=4
                    steps += Math.min(n + 1, last) - first;

                    // 进入下一层（十叉树）
                    // 示例：first=10, last=20
                    first *= 10;
                    last *= 10;
                }
                // 总数量=1（第一层）+4（第二层）=5
                return steps;
            }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
