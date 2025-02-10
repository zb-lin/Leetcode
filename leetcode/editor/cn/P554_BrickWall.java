//你的面前有一堵矩形的、由 n 行砖块组成的砖墙。这些砖块高度相同（也就是一个单位高）但是宽度不同。每一行砖块的宽度之和相等。 
//
// 你现在要画一条 自顶向下 的、穿过 最少 砖块的垂线。如果你画的线只是从砖块的边缘经过，就不算穿过这块砖。你不能沿着墙的两个垂直边缘之一画线，这样显然是没
//有穿过一块砖的。 
//
// 给你一个二维数组 wall ，该数组包含这堵墙的相关信息。其中，wall[i] 是一个代表从左至右每块砖的宽度的数组。你需要找出怎样画才能使这条线 穿过的
//砖块数量最少 ，并且返回 穿过的砖块数量 。 
//
// 
//
// 示例 1： 
// 
// 
//输入：wall = [[1,2,2,1],[3,1,2],[1,3,2],[2,4],[3,1,2],[1,3,1,1]]
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：wall = [[1],[1],[1]]
//输出：3
// 
//
// 
//
// 提示： 
//
// 
// n == wall.length 
// 1 <= n <= 10⁴ 
// 1 <= wall[i].length <= 10⁴ 
// 1 <= sum(wall[i].length) <= 2 * 10⁴ 
// 对于每一行 i ，sum(wall[i]) 是相同的 
// 1 <= wall[i][j] <= 2³¹ - 1 
// 
//
// Related Topics 数组 哈希表 👍 344 👎 0


package leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 砖墙
 *
 * @author lzb
 * @date 2024-10-10 21:51:23
 */
public class P554_BrickWall {
    public static void main(String[] args) {
        Solution solution = new P554_BrickWall().new Solution();
        List<Integer> list1 = Arrays.asList(1, 1);
        List<Integer> list2 = Arrays.asList(2);
        List<Integer> list3 = Arrays.asList(1, 1);
//        List<Integer> list4 = Arrays.asList(2, 4);
//        List<Integer> list5 = Arrays.asList(3, 1, 2);
//        List<Integer> list6 = Arrays.asList(1, 3, 1, 1);
        List<List<Integer>> list = Arrays.asList(list1, list2, list3);
        solution.leastBricks(list);
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int leastBricks(List<List<Integer>> wall) {
            Map<Integer, Integer> record = new HashMap<>();
            int maxCount = 0;
            for (List<Integer> row : wall) {
                int prev = 0;
                for (int i = 0; i < row.size() - 1; i++) {
                    prev += row.get(i);
                    record.put(prev, record.getOrDefault(prev, 0) + 1);
                    maxCount = Math.max(maxCount, record.get(prev));
                }
            }
            return wall.size() - maxCount;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
