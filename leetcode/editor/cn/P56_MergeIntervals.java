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

import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;

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
            Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
            Deque<int[]> deque = new LinkedList<>();
            deque.addFirst(intervals[0]);
            for (int i = 1; i < intervals.length; ++i) {
                int[] lastNode = deque.getFirst();
                if (lastNode[1] < intervals[i][0]) {
                    deque.addFirst(intervals[i]);
                } else {
                    if (intervals[i][1] > lastNode[1]) {
                        lastNode[1] = intervals[i][1];
                    }
                }
            }
            int[][] result = new int[deque.size()][2];
            int size = deque.size();
            for (int i = 0; i < size; ++i) {
                result[i] = deque.removeLast();
            }
            return result;
//            Arrays.sort(intervals, Comparator.comparingInt(interval -> interval[0]));
//            Deque<int[]> deque = new LinkedList<>();
//            deque.add(intervals[0]);
//            for (int i = 1; i < intervals.length; i++) {
//                int[] last = deque.peekLast();
//                int[] curr = intervals[i];
//                if (last[1] >= curr[1]) {
//                    continue;
//                }
//                if (last[1] < curr[0]) {
//                    deque.addLast(curr);
//                } else {
//                    last[1] = curr[1];
//                }
//            }
//            return deque.toArray(new int[deque.size()][]);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
