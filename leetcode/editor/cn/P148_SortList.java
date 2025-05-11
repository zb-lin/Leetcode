//给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。 
//
// 
// 
//
// 
//
// 示例 1： 
// 
// 
//输入：head = [4,2,1,3]
//输出：[1,2,3,4]
// 
//
// 示例 2： 
// 
// 
//输入：head = [-1,5,3,4,0]
//输出：[-1,0,3,4,5]
// 
//
// 示例 3： 
//
// 
//输入：head = []
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目在范围 [0, 5 * 10⁴] 内 
// -10⁵ <= Node.val <= 10⁵ 
// 
//
// 
//
// 进阶：你可以在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？ 
//
// Related Topics 链表 双指针 分治 排序 归并排序 👍 2315 👎 0


package leetcode.editor.cn;

/**
 * 排序链表
 *
 * @author lzb
 * @date 2024-06-10 22:36:43
 */
public class P148_SortList {
    public static void main(String[] args) {
        Solution solution = new P148_SortList().new Solution();
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
        public ListNode sortList(ListNode head) {
            if (head == null || head.next == null) return head;
            ListNode dummy = new ListNode(-1, head);
            ListNode fast = dummy, slow = dummy;
            while (fast != null && fast.next != null) {
                fast = fast.next.next;
                slow = slow.next;
            }
            ListNode next = slow.next;
            slow.next = null;
            ListNode left = sortList(head);
            ListNode right = sortList(next);
            return merge(left, right);
        }

        public ListNode merge(ListNode l1, ListNode l2) {
            ListNode dummy = new ListNode(-1);
            ListNode curr = dummy;
            while (l1 != null && l2 != null) {
                if (l1.val < l2.val) {
                    curr.next = l1;
                    l1 = l1.next;
                } else {
                    curr.next = l2;
                    l2 = l2.next;
                }
                curr = curr.next;
            }
            curr.next = l1 != null ? l1 : l2;
            return dummy.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
