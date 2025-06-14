//给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,1]
//输出：[[0,1],[1,0]]
// 
//
// 示例 3： 
//
// 
//输入：nums = [1]
//输出：[[1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 6 
// -10 <= nums[i] <= 10 
// nums 中的所有整数 互不相同 
// 
//
// Related Topics 数组 回溯 👍 2900 👎 0


package leetcode.editor.cn;

import java.util.*;

/**
 * 全排列
 *
 * @author lzb
 * @date 2024-06-10 21:23:44
 */
public class P46_Permutations {
    public static void main(String[] args) {
        Solution solution = new P46_Permutations().new Solution();
    }



    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        List<List<Integer>> res = new ArrayList<>();

        public List<List<Integer>> permute(int[] nums) {
            backtrack(nums, new LinkedList<>(), new boolean[nums.length]);
            return res;
        }

        private void backtrack(int[] nums, LinkedList<Integer> itemList, boolean[] visited) {
            if (itemList.size() == nums.length) {
                res.add(new ArrayList<>(itemList));
                return;
            }
            for (int i = 0; i < nums.length; ++i) {
                if (visited[i]) continue;
                visited[i] = true;
                itemList.addLast(nums[i]);
                backtrack(nums, itemList, visited);
                itemList.removeLast();
                visited[i] = false;

            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
