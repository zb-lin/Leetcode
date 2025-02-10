//给你一份工作时间表 hours，上面记录着某一位员工每天的工作小时数。 
//
// 我们认为当员工一天中的工作小时数大于 8 小时的时候，那么这一天就是「劳累的一天」。 
//
// 所谓「表现良好的时间段」，意味在这段时间内，「劳累的天数」是严格 大于「不劳累的天数」。 
//
// 请你返回「表现良好时间段」的最大长度。 
//
// 
//
// 示例 1： 
//
// 
//输入：hours = [9,9,6,0,6,6,9]
//输出：3
//解释：最长的表现良好时间段是 [9,9,6]。 
//
// 示例 2： 
//
// 
//输入：hours = [6,6,6]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= hours.length <= 10⁴ 
// 0 <= hours[i] <= 16 
// 
//
// Related Topics 栈 数组 哈希表 前缀和 单调栈 👍 544 👎 0


package leetcode.editor.cn;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 表现良好的最长时间段
 *
 * @author lzb
 * @date 2024-09-19 13:50:18
 */
public class P1124_LongestWellPerformingInterval {
    public static void main(String[] args) {
        Solution solution = new P1124_LongestWellPerformingInterval().new Solution();
        int[] hours = {9, 9, 6, 0, 6, 6, 9};
        solution.longestWPI(hours);
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int longestWPI(int[] hours) {
            int n = hours.length, ans = 0;
            int[] s = new int[n + 1]; // 前缀和
            Deque<Integer> st = new LinkedList<>();
            st.push(0); // s[0]
            for (int j = 1; j <= n; ++j) {
                s[j] = s[j - 1] + (hours[j - 1] > 8 ? 1 : -1);
                if (s[j] < s[st.peek()]) st.push(j); // 感兴趣的 j
            }
            for (int i = n; i > 0; --i)
                while (!st.isEmpty() && s[i] > s[st.peek()])
                    ans = Math.max(ans, i - st.pop()); // [栈顶,i) 可能是最长子数组
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
