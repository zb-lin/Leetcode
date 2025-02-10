//中位数是有序整数列表中的中间值。如果列表的大小是偶数，则没有中间值，中位数是两个中间值的平均值。 
//
// 
// 例如 arr = [2,3,4] 的中位数是 3 。 
// 例如 arr = [2,3] 的中位数是 (2 + 3) / 2 = 2.5 。 
// 
//
// 实现 MedianFinder 类: 
//
// 
// MedianFinder() 初始化 MedianFinder 对象。 
// void addNum(int num) 将数据流中的整数 num 添加到数据结构中。 
// double findMedian() 返回到目前为止所有元素的中位数。与实际答案相差 10⁻⁵ 以内的答案将被接受。 
// 
//
// 示例 1： 
//
// 
//输入
//["MedianFinder", "addNum", "addNum", "findMedian", "addNum", "findMedian"]
//[[], [1], [2], [], [3], []]
//输出
//[null, null, null, 1.5, null, 2.0]
//
//解释
//MedianFinder medianFinder = new MedianFinder();
//medianFinder.addNum(1);    // arr = [1]
//medianFinder.addNum(2);    // arr = [1, 2]
//medianFinder.findMedian(); // 返回 1.5 ((1 + 2) / 2)
//medianFinder.addNum(3);    // arr[1, 2, 3]
//medianFinder.findMedian(); // return 2.0 
//
// 提示: 
//
// 
// -10⁵ <= num <= 10⁵ 
// 在调用 findMedian 之前，数据结构中至少有一个元素 
// 最多 5 * 10⁴ 次调用 addNum 和 findMedian 
// 
//
// Related Topics 设计 双指针 数据流 排序 堆（优先队列） 👍 1036 👎 0


package leetcode.editor.cn;

import java.util.PriorityQueue;

/**
 * 数据流的中位数
 *
 * @author lzb
 * @date 2024-09-12 18:46:01
 */
public class P295_FindMedianFromDataStream {
    public static void main(String[] args) {
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class MedianFinder {
        PriorityQueue<Integer> pqMin;
        PriorityQueue<Integer> pqMax;

        public MedianFinder() {
            // 小顶堆
            pqMax = new PriorityQueue<>((a1, a2) -> a1 - a2);
            // 大顶堆
            pqMin = new PriorityQueue<>((a1, a2) -> a2 - a1);
        }

        /**
         * 左边大顶堆，右边小顶堆，小的加左边，大的加右边，平衡俩堆数，新加就弹出，堆顶给对家，奇数取多的，偶数取除2.
         * @param num
         */
        public void addNum(int num) {
            if (pqMin.isEmpty() || num <= pqMin.peek()) {
                pqMin.offer(num);
                if (pqMin.size() - pqMax.size() > 1) {
                    pqMax.offer(pqMin.poll());
                }
            } else {
                pqMax.offer(num);
                if (pqMax.size() - pqMin.size() > 0) {
                    pqMin.offer(pqMax.poll());
                }
            }
        }

        public double findMedian() {
            if (pqMin.size() > pqMax.size()) {
                return pqMin.peek();
            }
            return (pqMin.peek() + pqMax.peek()) / 2.0;
        }
    }

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
//leetcode submit region end(Prohibit modification and deletion)

}
