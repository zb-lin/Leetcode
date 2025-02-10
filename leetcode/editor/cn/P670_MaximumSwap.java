//给定一个非负整数，你至多可以交换一次数字中的任意两位。返回你能得到的最大值。 
//
// 示例 1 : 
//
// 
//输入: 2736
//输出: 7236
//解释: 交换数字2和数字7。
// 
//
// 示例 2 : 
//
// 
//输入: 9973
//输出: 9973
//解释: 不需要交换。
// 
//
// 注意: 
//
// 
// 给定数字的范围是 [0, 10⁸] 
// 
//
// Related Topics 贪心 数学 👍 491 👎 0


package leetcode.editor.cn;

import javafx.util.Pair;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 最大交换
 *
 * @author lzb
 * @date 2024-09-28 17:26:53
 */
public class P670_MaximumSwap {
    public static void main(String[] args) {
        Solution solution = new P670_MaximumSwap().new Solution();
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maximumSwap(int num) {
            Deque<Pair<Character, Integer>> deque = new LinkedList<>();
            char[] array = Integer.toString(num).toCharArray();
            for (int i = 0; i < array.length; i++) {
                while (!deque.isEmpty() && deque.getLast().getKey() < array[i]) {
                    deque.removeLast();
                }
                deque.addLast(new Pair<>(array[i], i));
            }
            for (int i = 0; i < array.length; i++) {
                if (deque.getFirst().getKey() == array[i]) {
                    deque.removeFirst();
                } else {
                    Pair<Character, Integer> curr = deque.removeFirst();
                    while (!deque.isEmpty() && curr.getKey() == deque.getFirst().getKey()) {
                        curr = deque.removeFirst();
                    }
                    swap(array, curr.getValue(), i);
                    return Integer.parseInt(new String(array));
                }
            }
            return num;
        }

        public void swap(char[] array, int i, int j) {
            char temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
