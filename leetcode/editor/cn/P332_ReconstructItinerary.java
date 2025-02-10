//给你一份航线列表 tickets ，其中 tickets[i] = [fromi, toi] 表示飞机出发和降落的机场地点。请你对该行程进行重新规划排序。 
//
//
// 所有这些机票都属于一个从 JFK（肯尼迪国际机场）出发的先生，所以该行程必须从 JFK 开始。如果存在多种有效的行程，请你按字典排序返回最小的行程组合。 
//
//
// 
// 例如，行程 ["JFK", "LGA"] 与 ["JFK", "LGB"] 相比就更小，排序更靠前。 
// 
//
// 假定所有机票至少存在一种合理的行程。且所有的机票 必须都用一次 且 只能用一次。 
//
// 
//
// 示例 1： 
// 
// 
//输入：tickets = [["MUC","LHR"],["JFK","MUC"],["SFO","SJC"],["LHR","SFO"]]
//输出：["JFK","MUC","LHR","SFO","SJC"]
// 
//
// 示例 2： 
// 
// 
//输入：tickets = [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL",
//"SFO"]]
//输出：["JFK","ATL","JFK","SFO","ATL","SFO"]
//解释：另一种有效的行程是 ["JFK","SFO","ATL","JFK","ATL","SFO"] ，但是它字典排序更大更靠后。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= tickets.length <= 300 
// tickets[i].length == 2 
// fromi.length == 3 
// toi.length == 3 
// fromi 和 toi 由大写英文字母组成 
// fromi != toi 
// 
//
// Related Topics 深度优先搜索 图 欧拉回路 👍 914 👎 0


package leetcode.editor.cn;

import java.util.*;

/**
 * 重新安排行程
 *
 * @author lzb
 * @date 2024-06-28 18:38:07
 */
public class P332_ReconstructItinerary {
    public static void main(String[] args) {
        List<List<String>> tickets = Arrays.asList(
                Arrays.asList("JFK", "ANU"),
                Arrays.asList("JFK", "TIA"),
                Arrays.asList("TIA", "ANU"),
                Arrays.asList("TIA", "ANU"),
                Arrays.asList("TIA", "JFK"),
                Arrays.asList("ANU", "EZE"),
                Arrays.asList("ANU", "TIA"),
                Arrays.asList("ANU", "JFK"),
                Arrays.asList("AXA", "TIA"),
                Arrays.asList("EZE", "AXA")
        );
        Solution solution = new P332_ReconstructItinerary().new Solution();

        solution.findItinerary(tickets);

    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        LinkedList<String> res = new LinkedList<>();
        /**
         * 起点 -> 终点 票数
         */
        Map<String, Map<String, Integer>> cache = new HashMap<>();

        public List<String> findItinerary(List<List<String>> tickets) {
            tickets.forEach(track -> {
                Map<String, Integer> endMap = cache.getOrDefault(track.get(0), new TreeMap<>());
                endMap.put(track.get(1), endMap.getOrDefault(track.get(1), 0) + 1);
                cache.put(track.get(0), endMap);
            });
            res.add("JFK");
            backtrack(tickets.size());
            return res;
        }

        public boolean backtrack(int size) {
            if (size + 1 == res.size()) {
                return true;
            }
            String start = res.peekLast();
            if (cache.get(start) == null) return false;
            for (Map.Entry<String, Integer> endCountEntry : cache.get(start).entrySet()) {
                if (endCountEntry.getValue() <= 0) continue;
                endCountEntry.setValue(endCountEntry.getValue() - 1);
                res.add(endCountEntry.getKey());
                if (backtrack(size)) {
                    return true;
                }
                res.removeLast();
                endCountEntry.setValue(endCountEntry.getValue() + 1);
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
