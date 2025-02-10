//给你链表的头节点 head ，每 k 个节点一组进行翻转，请你返回修改后的链表。 
//
// k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。 
//
// 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。 
//
// 
//
// 示例 1： 
// 
// 
//输入：head = [1,2,3,4,5], k = 2
//输出：[2,1,4,3,5]
// 
//
// 示例 2： 
//
// 
//
// 
//输入：head = [1,2,3,4,5], k = 3
//输出：[3,2,1,4,5]
// 
//
// 
//提示：
//
// 
// 链表中的节点数目为 n 
// 1 <= k <= n <= 5000 
// 0 <= Node.val <= 1000 
// 
//
// 
//
// 进阶：你可以设计一个只用 O(1) 额外内存空间的算法解决此问题吗？ 
//
// 
// 
//
// Related Topics 递归 链表 👍 2331 👎 0


package leetcode.editor.cn;

import java.util.Arrays;

/**
 * K 个一组翻转链表
 *
 * @author lzb
 * @date 2024-05-23 19:08:01
 */
public class P25_ReverseNodesInKGroup {
    public static void main(String[] args) {
        Solution solution = new P25_ReverseNodesInKGroup().new Solution();
        ListNode p1 = new ListNode(1);
        ListNode p2 = new ListNode(2);
        p1.next = p2;
        solution.reverseKGroup(p1, 2);
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
        public ListNode reverseKGroup(ListNode head, int k) {
            ListNode dummy = new ListNode(-1, head);
            ListNode prev = dummy;
            ListNode tail = dummy;
            while (head != null) {
                for (int i = 0; i < k; i++) {
                    tail = tail.next;
                    if (tail == null) return dummy.next;
                }
                ListNode next = tail.next;
                ListNode[] listNodes = reverse(head, tail);
                head = listNodes[0];
                tail = listNodes[1];
                tail.next = next;
                prev.next = head;
                head = next;
                prev = tail;
            }
            return dummy.next;
        }

        public ListNode[] reverse(ListNode head, ListNode tail) {
            ListNode prev = tail.next;
            ListNode curr = head;
            while (prev != tail) {
                ListNode next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }
            return new ListNode[]{tail, head};
        }


        /*public ListNode reverseKGroup(ListNode head, int k) {
            Deque<ListNode> deque = new LinkedList<>();
            ListNode p = head;
            ListNode dummy = new ListNode(-1);
            ListNode q = dummy;
            while (p != null) {
                deque.addFirst(p);
                p = p.next;
                if (deque.size() == k) {
                    while (!deque.isEmpty()) {
                        q.next = deque.removeFirst();
                        q = q.next;
                    }
                }
            }
            while (!deque.isEmpty()) {
                q.next = deque.removeLast();
                q = q.next;
            }
            q.next = null;
            return dummy.next;
        }*/
    }
//leetcode submit region end(Prohibit modification and deletion)

}
