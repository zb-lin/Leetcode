//给定一组非负整数 nums，重新排列每个数的顺序（每个数不可拆分）使之组成一个最大的整数。 
//
// 注意：输出结果可能非常大，所以你需要返回一个字符串而不是整数。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [10,2]
//输出："210" 
//
// 示例 2： 
//
// 
//输入：nums = [3,30,34,5,9]
//输出："9534330"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 100 
// 0 <= nums[i] <= 10⁹ 
// 
//
// Related Topics 贪心 数组 字符串 排序 👍 1288 👎 0


package leetcode.editor.cn;

import java.util.Arrays;

/**
 * 最大数
 *
 * @author lzb
 * @date 2024-09-04 21:19:41
 */
public class P179_LargestNumber {
    public static void main(String[] args) {
        Solution solution = new P179_LargestNumber().new Solution();
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String largestNumber(int[] nums) {
            String[] array = Arrays.stream(nums)
                    .mapToObj(String::valueOf)
                    .sorted((s1, s2) -> {
                        String s3 = s1 + s2;
                        String s4 = s2 + s1;
                        return s4.compareTo(s3);
                    }).toArray(String[]::new);
            if ("0".equals(array[0])) {
                return "0";
            }
            StringBuilder res = new StringBuilder();
            for (String str : array) {
                res.append(str);
            }
            return res.toString();
        }
    }

//leetcode submit region end(Prohibit modification and deletion)
}


