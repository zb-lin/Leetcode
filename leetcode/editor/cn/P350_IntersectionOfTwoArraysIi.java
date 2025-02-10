//给你两个整数数组 nums1 和 nums2 ，请你以数组形式返回两数组的交集。返回结果中每个元素出现的次数，应与元素在两个数组中都出现的次数一致（如果出现
//次数不一致，则考虑取较小值）。可以不考虑输出结果的顺序。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums1 = [1,2,2,1], nums2 = [2,2]
//输出：[2,2]
// 
//
// 示例 2: 
//
// 
//输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
//输出：[4,9] 
//
// 
//
// 提示： 
//
// 
// 1 <= nums1.length, nums2.length <= 1000 
// 0 <= nums1[i], nums2[i] <= 1000 
// 
//
// 
//
// 进阶： 
//
// 
// 如果给定的数组已经排好序呢？你将如何优化你的算法？ 
// 如果 nums1 的大小比 nums2 小，哪种方法更优？ 
// 如果 nums2 的元素存储在磁盘上，内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？ 
// 
//
// Related Topics 数组 哈希表 双指针 二分查找 排序 👍 1044 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 两个数组的交集 II
 *
 * @author lzb
 * @date 2024-06-21 11:21:31
 */
public class P350_IntersectionOfTwoArraysIi {
    public static void main(String[] args) {
        Solution solution = new P350_IntersectionOfTwoArraysIi().new Solution();
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] intersect(int[] nums1, int[] nums2) {
            Map<Integer, Integer> record = new HashMap<>();
            List<Integer> resList = new ArrayList<>();
            for (int num : nums1) {
                record.put(num, record.getOrDefault(num, 0) + 1);
            }
            for (int num : nums2) {
                if (record.getOrDefault(num, 0) > 0) {
                    resList.add(num);
                    record.put(num, record.getOrDefault(num, 0) - 1);
                }
            }
            return resList.stream().mapToInt(Integer::valueOf).toArray();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
