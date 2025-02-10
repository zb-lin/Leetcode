//在股票交易中，如果前一天的股价高于后一天的股价，则可以认为存在一个「交易逆序对」。请设计一个程序，输入一段时间内的股票交易记录 record，返回其中存在的
//「交易逆序对」总数。 
//
// 
//
// 示例 1: 
//
// 
//输入：record = [9, 7, 5, 4, 6]
//输出：8
//解释：交易中的逆序对为 (9, 7), (9, 5), (9, 4), (9, 6), (7, 5), (7, 4), (7, 6), (5, 4)。
// 
//
// 
//
// 限制： 
//
// 0 <= record.length <= 50000 
//
// Related Topics 树状数组 线段树 数组 二分查找 分治 有序集合 归并排序 👍 1110 👎 0


package leetcode.editor.cn;

/**
 * 交易逆序对的总数
 *
 * @author lzb
 * @date 2024-09-09 13:01:15
 */
public class PLCR_170_ShuZuZhongDeNiXuDuiLcof {
    public static void main(String[] args) {
        Solution solution = new PLCR_170_ShuZuZhongDeNiXuDuiLcof().new Solution();
        int[] record = {9, 7, 5, 4, 6};
        solution.reversePairs(record);
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int count = 0;

        public int reversePairs(int[] record) {
            mergeSort(record, 0, record.length - 1, new int[record.length]);
            return count;
        }

        public void mergeSort(int[] record, int left, int right, int[] help) {
            if (left < right) {
                int mid = left + (right - left) / 2;
                mergeSort(record, left, mid, help);
                mergeSort(record, mid + 1, right, help);
                merge(record, left, mid, right, help);
            }
        }

        public void merge(int[] record, int left, int mid, int right, int[] help) {
            int p1 = left;
            int p2 = mid + 1;
            int ptr = 0;
            while (p1 <= mid && p2 <= right) {
                if (record[p1] <= record[p2]) {
                    help[ptr++] = record[p1++];
                } else {
                    count += mid - p1 + 1;
                    help[ptr++] = record[p2++];
                }
            }
            while (p1 <= mid) {
                help[ptr++] = record[p1++];
            }
            while (p2 <= right) {
                help[ptr++] = record[p2++];
            }
            for (int i = 0; i < right - left + 1; ++i) {
                record[left + i] = help[i];
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
