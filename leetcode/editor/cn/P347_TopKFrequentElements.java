//给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [1,1,1,2,2,3], k = 2
//输出: [1,2]
// 
//
// 示例 2: 
//
// 
//输入: nums = [1], k = 1
//输出: [1] 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// k 的取值范围是 [1, 数组中不相同的元素的个数] 
// 题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的 
// 
//
// 
//
// 进阶：你所设计算法的时间复杂度 必须 优于 O(n log n) ，其中 n 是数组大小。 
//
// Related Topics 数组 哈希表 分治 桶排序 计数 快速选择 排序 堆（优先队列） 👍 1849 👎 0


package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 前 K 个高频元素
 *
 * @author lzb
 * @date 2024-06-24 12:45:44
 */
public class P347_TopKFrequentElements {
    public static void main(String[] args) {
//        Solution solution = new P347_TopKFrequentElements().new Solution();
    }


    //leetcode submit region begin(Prohibit modification and deletion)

    class Node {
        int key;
        int count;

        public Node(int key, int count) {
            this.key = key;
            this.count = count;
        }
    }

    class Solution {
        public int[] topKFrequent(int[] nums, int k) {
            Map<Integer, Integer> cache = new HashMap<>();
            for (int i = 0; i < nums.length; ++i) {
                cache.put(nums[i], cache.getOrDefault(nums[i], 0) + 1);
            }

            PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> b.count - a.count);
            for (Map.Entry<Integer, Integer> entry : cache.entrySet()) {
                Integer key = entry.getKey();
                Integer count = entry.getValue();
                pq.add(new Node(key, count));
            }
            int[] result = new int[k];
            for (int i = 0; i < k; i++) {
                result[i] = pq.poll().key;
            }
            return result;
        }
    }




/*    class Node {
        int num;
        int count;

        public Node(int num, int count) {
            this.num = num;
            this.count = count;
        }
    }

    class Solution {

        public int[] topKFrequent(int[] nums, int k) {
            Map<Integer, Integer> cache = new HashMap<>();
            for (int num : nums) {
                cache.put(num, cache.getOrDefault(num, 0) + 1);
            }
            PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> b.count - a.count);
            for (Map.Entry<Integer, Integer> entry : cache.entrySet()) {
                pq.add(new Node(entry.getKey(), entry.getValue()));
            }
            int[] res = new int[k];
            for (int i = 0; i < k; i++) {
                res[i] = pq.poll().num;
            }
            return res;
        }
    }*/
//leetcode submit region end(Prohibit modification and deletion)

}
