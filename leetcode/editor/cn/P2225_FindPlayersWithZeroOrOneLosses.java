//给你一个整数数组 matches 其中 matches[i] = [winneri, loseri] 表示在一场比赛中 winneri 击败了 
//loseri 。 
//
// 返回一个长度为 2 的列表 answer ： 
//
// 
// answer[0] 是所有 没有 输掉任何比赛的玩家列表。 
// answer[1] 是所有恰好输掉 一场 比赛的玩家列表。 
// 
//
// 两个列表中的值都应该按 递增 顺序返回。 
//
// 注意： 
//
// 
// 只考虑那些参与 至少一场 比赛的玩家。 
// 生成的测试用例保证 不存在 两场比赛结果 相同 。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：matches = [[1,3],[2,3],[3,6],[5,6],[5,7],[4,5],[4,8],[4,9],[10,4],[10,9]]
//输出：[[1,2,10],[4,5,7,8]]
//解释：
//玩家 1、2 和 10 都没有输掉任何比赛。
//玩家 4、5、7 和 8 每个都输掉一场比赛。
//玩家 3、6 和 9 每个都输掉两场比赛。
//因此，answer[0] = [1,2,10] 和 answer[1] = [4,5,7,8] 。
// 
//
// 示例 2： 
//
// 
//输入：matches = [[2,3],[1,3],[5,4],[6,4]]
//输出：[[1,2,5,6],[]]
//解释：
//玩家 1、2、5 和 6 都没有输掉任何比赛。
//玩家 3 和 4 每个都输掉两场比赛。
//因此，answer[0] = [1,2,5,6] 和 answer[1] = [] 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= matches.length <= 10⁵ 
// matches[i].length == 2 
// 1 <= winneri, loseri <= 10⁵ 
// winneri != loseri 
// 所有 matches[i] 互不相同 
// 
//
// Related Topics 数组 哈希表 计数 排序 👍 24 👎 0


package leetcode.editor.cn;

import java.util.*;

/**
 * 找出输掉零场或一场比赛的玩家
 *
 * @author lzb
 * @date 2024-05-22 02:03:39
 */
public class P2225_FindPlayersWithZeroOrOneLosses {
    public static void main(String[] args) {
        Solution solution = new P2225_FindPlayersWithZeroOrOneLosses().new Solution();
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> findWinners(int[][] matches) {
            Set<Integer> matchSet = new HashSet<>();
            // key: loser  value: count
            Map<Integer, Integer> map = new HashMap<>();
            for (int[] match : matches) {
                map.put(match[1], map.getOrDefault(match[1], 0) + 1);
                matchSet.add(match[0]);
                matchSet.add(match[1]);
            }
            List<Integer> matchList = new ArrayList<>(matchSet);
            Collections.sort(matchList);
            List<Integer> loserOne = new ArrayList<>();
            List<Integer> winAll = new ArrayList<>();
            matchList.forEach(item -> {
                if (!map.containsKey(item)) {
                    winAll.add(item);
                } else if (map.get(item) == 1) {
                    loserOne.add(item);
                }
            });
            List<List<Integer>> res = new ArrayList<>();
            res.add(winAll);
            res.add(loserOne);
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
