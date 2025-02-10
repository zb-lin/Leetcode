//仓库管理员以数组 stock 形式记录商品库存表，其中 stock[i] 表示对应商品库存余量。请返回库存余量最少的 cnt 个商品余量，返回 顺序不限。 
//
//
// 
//
// 示例 1： 
//
// 
//输入：stock = [2,5,7,4], cnt = 1
//输出：[2]
// 
//
// 示例 2： 
//
// 
//输入：stock = [0,2,3,6], cnt = 2
//输出：[0,2] 或 [2,0] 
//
// 
//
// 提示： 
//
// 
// 0 <= cnt <= stock.length <= 10000 0 <= stock[i] <= 10000 
// 
//
// 
//
// Related Topics 数组 分治 快速选择 排序 堆（优先队列） 👍 594 👎 0


package leetcode.editor.cn;

import java.util.Arrays;

/**
 * 库存管理 III
 *
 * @author lzb
 * @date 2024-09-09 22:22:31
 */
public class PLCR_159_ZuiXiaoDeKgeShuLcof {
    public static void main(String[] args) {
        Solution solution = new PLCR_159_ZuiXiaoDeKgeShuLcof().new Solution();
 /*       int[] stock = {0, 0, 2, 3, 2, 1, 1, 2, 0, 4};
        System.out.println(Arrays.toString(solution.inventoryManagement(stock, 10)));
        System.out.println(Arrays.toString(stock));*/
        System.out.println(solution.getClass() == Solution.class);
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] inventoryManagement(int[] stock, int cnt) {
            for (int i = 0; i < stock.length; ++i) {
                heapInsert(stock, i);
            }
            int size = stock.length - 1;
            int[] result = new int[cnt];
            int idx = 0;
            while (size > 0) {
                swap(stock, 0, size);
                result[idx++] = stock[size];
                if (idx == result.length) break;
                heapity(stock, size--);
            }
            if (cnt == stock.length) {
                result[result.length - 1] = stock[0];
            }
            return result;
        }

        public void heapInsert(int[] nums, int i) {
            while (nums[i] < nums[(i - 1) / 2]) {
                swap(nums, i, (i - 1) / 2);
                i = (i - 1) / 2;
            }
        }

        public void heapity(int[] nums, int size) {
            int curr = 0;
            int left = 1;
            while (left < size) {
                int min = left + 1 < size && nums[left + 1] < nums[left] ? left + 1 : left;
                min = nums[curr] < nums[min] ? curr : min;
                if (curr == min)
                    return;
                swap(nums, curr, min);
                curr = min;
                left = curr * 2 + 1;
            }
        }

        public void swap(int[] nums, int i, int j) {
            if (i == j)
                return;
            nums[i] = nums[i] ^ nums[j];
            nums[j] = nums[i] ^ nums[j];
            nums[i] = nums[i] ^ nums[j];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
