//给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。请你反转从位置 left 到位置 right 的链
//表节点，返回 反转后的链表 。
//
// 
//
// 示例 1： 
// 
// 
//输入：head = [1,2,3,4,5], left = 2, right = 4
//输出：[1,4,3,2,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [5], left = 1, right = 1
//输出：[5]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点数目为 n 
// 1 <= n <= 500 
// -500 <= Node.val <= 500 
// 1 <= left <= right <= n 
// 
//
// 
//
// 进阶： 你可以使用一趟扫描完成反转吗？ 
//
// Related Topics 链表 👍 1795 👎 0


package leetcode.editor.cn;

import java.util.List;

/**
 * 反转链表 II
 *
 * @author lzb
 * @date 2024-06-11 11:36:16
 */
public class P92_ReverseLinkedListIi {
    public static void main(String[] args) {
        Solution solution = new P92_ReverseLinkedListIi().new Solution();
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
        public ListNode reverseBetween(ListNode head, int left, int right) {
            ListNode dummy = new ListNode(-1, head);
            ListNode prev = dummy;
            for (int i = 0; i < left - 1; ++i) {
                prev = prev.next;
            }
            ListNode leftNode = prev.next;
            ListNode rightNode = leftNode;

            for (int i = 0; i < right - left; ++i) {
                rightNode = rightNode.next;
            }
            ListNode tail = rightNode.next;
            ListNode[] result = reverse(leftNode, rightNode);
            leftNode = result[0];
            rightNode = result[1];
            prev.next = leftNode;
            rightNode.next = tail;
            return dummy.next;
        }

        public ListNode[] reverse(ListNode head, ListNode tail) {
            ListNode prev = tail.next, curr = head;
            while (prev != tail) {
                ListNode next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }
            return new ListNode[]{tail, head};
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
