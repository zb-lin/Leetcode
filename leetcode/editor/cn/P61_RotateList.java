//给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。 
//
// 
//
// 示例 1： 
// 
// 
//输入：head = [1,2,3,4,5], k = 2
//输出：[4,5,1,2,3]
// 
//
// 示例 2： 
// 
// 
//输入：head = [0,1,2], k = 4
//输出：[2,0,1]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目在范围 [0, 500] 内 
// -100 <= Node.val <= 100 
// 0 <= k <= 2 * 10⁹ 
// 
//
// Related Topics 链表 双指针 👍 1050 👎 0


package leetcode.editor.cn;

/**
 * 旋转链表
 *
 * @author lzb
 * @date 2024-05-25 11:03:22
 */
public class P61_RotateList {
    public static void main(String[] args) {
        Solution solution = new P61_RotateList().new Solution();
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
        public ListNode rotateRight(ListNode head, int k) {
            if (head == null || head.next == null) return head;
            int count = 1;
            ListNode q = head;
            while (q.next != null) {
                q = q.next;
                count++;
            }
            for (int i = 0; i < k % count; i++) {
                ListNode p = head;
                while (p.next.next != null) {
                    p = p.next;
                }
                ListNode last = p.next;
                p.next = null;
                last.next = head;
                head = last;
            }
            return head;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
