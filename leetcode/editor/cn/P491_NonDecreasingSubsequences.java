//给你一个整数数组 nums ，找出并返回所有该数组中不同的递增子序列，递增子序列中 至少有两个元素 。你可以按 任意顺序 返回答案。 
//
// 数组中可能含有重复元素，如出现两个整数相等，也可以视作递增序列的一种特殊情况。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [4,6,7,7]
//输出：[[4,6],[4,6,7],[4,6,7,7],[4,7],[4,7,7],[6,7],[6,7,7],[7,7]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [4,4,3,2,1]
//输出：[[4,4]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 15 
// -100 <= nums[i] <= 100 
// 
//
// Related Topics 位运算 数组 哈希表 回溯 👍 795 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 非递减子序列
 *
 * @author lzb
 * @date 2024-06-28 18:04:19
 */
public class P491_NonDecreasingSubsequences {
    public static void main(String[] args) {
        Solution solution = new P491_NonDecreasingSubsequences().new Solution();
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<Integer> track = new LinkedList<>();

        public List<List<Integer>> findSubsequences(int[] nums) {
            backtrack(nums, 0);
            return res;
        }

        public void backtrack(int[] nums, int startIndex) {
            if (track.size() > 1) {
                res.add(new ArrayList<>(track));
            }
            int[] usd = new int[201];
            for (int i = startIndex; i < nums.length; i++) {
                if (!track.isEmpty() && nums[i] < track.peekLast()
                        || (usd[nums[i] + 100] == 1)) continue;
                usd[nums[i] + 100] = 1;
                track.add(nums[i]);
                backtrack(nums, i + 1);
                track.removeLast();
            }
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
