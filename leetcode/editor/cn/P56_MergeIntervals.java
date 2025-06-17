//以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返
//回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。 
//
// 
//
// 示例 1： 
//
// 
//输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
//输出：[[1,6],[8,10],[15,18]]
//解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
// 
//
// 示例 2： 
//
// 
//输入：intervals = [[1,4],[4,5]]
//输出：[[1,5]]
//解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。 
//
// 
//
// 提示： 
//
// 
// 1 <= intervals.length <= 10⁴ 
// intervals[i].length == 2 
// 0 <= starti <= endi <= 10⁴ 
// 
//
// Related Topics 数组 排序 👍 2332 👎 0


package leetcode.editor.cn;

import java.util.*;

/**
 * 合并区间
 *
 * @author lzb
 * @date 2024-05-22 01:15:37
 */
public class P56_MergeIntervals {
    public static void main(String[] args) {
        Solution solution = new P56_MergeIntervals().new Solution();
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        solution.merge(intervals);
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] merge(int[][] intervals) {
            Arrays.sort(intervals, (arr1, arr2) -> {
                return arr1[0] - arr2[0];
            });
            Deque<int[]> deque = new LinkedList<>();
            for (int i = 0; i < intervals.length; ++i) {
                int[] curr = intervals[i];
                if (deque.isEmpty()) {
                    deque.addLast(curr);
                    continue;
                }
                int[] prev = deque.removeLast();
                if (prev[1] < curr[0]) {
                    deque.addLast(prev);
                    deque.addLast(curr);
                } else if (prev[1] >= curr[1]) {
                    deque.addLast(prev);
                } else {
                    deque.addLast(new int[] {prev[0], curr[1]});
                }
            }
            int size = deque.size();
            int[][] result = new int[size][2];
            for (int i = 0; i < size; ++i) {
                result[i] = deque.removeFirst();
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
