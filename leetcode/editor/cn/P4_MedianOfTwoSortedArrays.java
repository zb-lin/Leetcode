//给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。 
//
// 算法的时间复杂度应该为 O(log (m+n)) 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums1 = [1,3], nums2 = [2]
//输出：2.00000
//解释：合并数组 = [1,2,3] ，中位数 2
// 
//
// 示例 2： 
//
// 
//输入：nums1 = [1,2], nums2 = [3,4]
//输出：2.50000
//解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
// 
//
// 
//
// 
//
// 提示： 
//
// 
// nums1.length == m 
// nums2.length == n 
// 0 <= m <= 1000 
// 0 <= n <= 1000 
// 1 <= m + n <= 2000 
// -10⁶ <= nums1[i], nums2[i] <= 10⁶ 
// 
//
// Related Topics 数组 二分查找 分治 👍 7146 👎 0


package leetcode.editor.cn;

/**
 * 寻找两个正序数组的中位数
 *
 * @author lzb
 * @date 2024-06-10 20:14:23
 */
public class P4_MedianOfTwoSortedArrays {
    public static void main(String[] args) {
        Solution solution = new P4_MedianOfTwoSortedArrays().new Solution();
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            int m = nums1.length, n = nums2.length;
            int left = (m + n + 1) / 2;
            int right = (m + n + 2) / 2;
            return (getKth(nums1, 0, m - 1, nums2, 0, n - 1, left)
                    + getKth(nums1, 0, m - 1, nums2, 0, n - 1, right)) * 0.5;
        }

        public int getKth(int[] nums1, int start1, int end1, int[] nums2, int start2, int end2, int k) {
            int len1 = end1 - start1 + 1;
            int len2 = end2 - start2 + 1;
            if (len1 > len2) {
                return getKth(nums2, start2, end2, nums1, start1, end1, k);
            }
            if (len1 == 0) {
                return nums2[start2 + k - 1];
            }
            if (k == 1) {
                return Math.min(nums1[start1], nums2[start2]);
            }
            int i = start1 + Math.min(len1, k / 2) - 1;
            int j = start2 + Math.min(len2, k / 2) - 1;
            if (nums1[i] < nums2[j]) {
                return getKth(nums1, i + 1, end1, nums2, start2, end2, k - (i - start1 + 1));
            } else {
                return getKth(nums1, start1, end1, nums2, j + 1, end2, k - (j - start2 + 1));
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
