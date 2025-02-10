//给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。 
//
// 
//
// 示例 1： 
// 
// 
//输入：head = [1,2,3,4]
//输出：[2,1,4,3]
// 
//
// 示例 2： 
//
// 
//输入：head = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：head = [1]
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目在范围 [0, 100] 内 
// 0 <= Node.val <= 100 
// 
//
// Related Topics 递归 链表 👍 2224 👎 0


package leetcode.editor.cn;

/**
 * 两两交换链表中的节点
 *
 * @author lzb
 * @date 2024-06-20 13:36:25
 */
public class P24_SwapNodesInPairs {
    public static void main(String[] args) {
        Solution solution = new P24_SwapNodesInPairs().new Solution();
    }


//leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {


        public ListNode swapPairs(ListNode head) {
            ListNode dummy = new ListNode(0, head);
            ListNode curr = dummy;
            while (curr.next != null && curr.next.next != null) {
                ListNode first = curr.next;
                ListNode second = curr.next.next;
                first.next = second.next;
                second.next = first;
                curr.next = second;
                curr = first;
            }
            return dummy.next;
        }

        /**
         * 递归
         */
        public ListNode swapPairs1(ListNode head) {
            if (head == null || head.next == null) return head;
            ListNode next = head.next;
            // 获得后续排好的链表
            ListNode newNode = swapPairs1(next.next);
            // 翻转前两个节点
            next.next = head;
            head.next = newNode;
            return next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
