//给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位
//。 
//
// 返回 滑动窗口中的最大值 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
//输出：[3,3,5,5,6,7]
//解释：
//滑动窗口的位置                最大值
//---------------               -----
//[1  3  -1] -3  5  3  6  7       3
// 1 [3  -1  -3] 5  3  6  7       3
// 1  3 [-1  -3  5] 3  6  7       5
// 1  3  -1 [-3  5  3] 6  7       5
// 1  3  -1  -3 [5  3  6] 7       6
// 1  3  -1  -3  5 [3  6  7]      7
// 
//
// 示例 2： 
//
// 
//输入：nums = [1], k = 1
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// -10⁴ <= nums[i] <= 10⁴ 
// 1 <= k <= nums.length 
// 
//
// Related Topics 队列 数组 滑动窗口 单调队列 堆（优先队列） 👍 2800 👎 0


package leetcode.editor.cn;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 滑动窗口最大值
 *
 * @author lzb
 * @date 2024-06-10 23:02:19
 */
public class P239_SlidingWindowMaximum {
    public static void main(String[] args) {
    }

}
//leetcode submit region begin(Prohibit modification and deletion)



class Solution {
    class MyQueue {
        Deque<Integer> deque;
        MyQueue() {
            deque = new LinkedList<>();
        }
        void put(int val) {
            while (!deque.isEmpty() && val > deque.getLast()) {
                deque.removeLast();
            }
            deque.addLast(val);
        }

        void poll(int val) {
            if (!deque.isEmpty() && deque.getFirst() == val) {
                deque.removeFirst();
            }
        }

        int getMax() {
            return deque.getFirst();
        }
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];
        MyQueue myQueue = new MyQueue();
        for (int i = 0; i < k; ++i) {
            myQueue.put(nums[i]);
        }
        res[0] = myQueue.getMax();
        for (int i = k; i < nums.length; ++i) {
            myQueue.poll(nums[i - k]);
            myQueue.put(nums[i]);
            res[i - k + 1] = myQueue.getMax();;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)