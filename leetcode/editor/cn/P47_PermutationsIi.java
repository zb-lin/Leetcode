//给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,1,2]
//输出：
//[[1,1,2],
// [1,2,1],
// [2,1,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 8 
// -10 <= nums[i] <= 10 
// 
//
// Related Topics 数组 回溯 👍 1580 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 全排列 II
 *
 * @author lzb
 * @date 2024-06-28 18:21:57
 */
public class P47_PermutationsIi {
    public static void main(String[] args) {
        Solution solution = new P47_PermutationsIi().new Solution();
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<Integer> track = new LinkedList<>();
        boolean[] usd;

        public List<List<Integer>> permuteUnique(int[] nums) {
            usd = new boolean[nums.length];
            Arrays.sort(nums);
            backtrack(nums);
            return res;
        }

        public void backtrack(int[] nums) {
            if (track.size() == nums.length) {
                res.add(new ArrayList<>(track));
                return;
            }
            for (int i = 0; i < nums.length; i++) {
                if (i > 0 && nums[i] == nums[i - 1] && !usd[i - 1]) continue;
                if (usd[i]) continue;
                usd[i] = true;
                track.add(nums[i]);
                backtrack(nums);
                track.removeLast();
                usd[i] = false;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
