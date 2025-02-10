//你可以选择使用单链表或者双链表，设计并实现自己的链表。 
//
// 单链表中的节点应该具备两个属性：val 和 next 。val 是当前节点的值，next 是指向下一个节点的指针/引用。 
//
// 如果是双向链表，则还需要属性 prev 以指示链表中的上一个节点。假设链表中的所有节点下标从 0 开始。 
//
// 实现 MyLinkedList 类： 
//
// 
// MyLinkedList() 初始化 MyLinkedList 对象。 
// int get(int index) 获取链表中下标为 index 的节点的值。如果下标无效，则返回 -1 。 
// void addAtHead(int val) 将一个值为 val 的节点插入到链表中第一个元素之前。在插入完成后，新节点会成为链表的第一个节点。 
// void addAtTail(int val) 将一个值为 val 的节点追加到链表中作为链表的最后一个元素。 
// void addAtIndex(int index, int val) 将一个值为 val 的节点插入到链表中下标为 index 的节点之前。如果 
//index 等于链表的长度，那么该节点会被追加到链表的末尾。如果 index 比长度更大，该节点将 不会插入 到链表中。 
// void deleteAtIndex(int index) 如果下标有效，则删除链表中下标为 index 的节点。 
// 
//
// 
//
// 示例： 
//
// 
//输入
//["MyLinkedList", "addAtHead", "addAtTail", "addAtIndex", "get", 
//"deleteAtIndex", "get"]
//[[], [1], [3], [1, 2], [1], [1], [1]]
//输出
//[null, null, null, null, 2, null, 3]
//
//解释
//MyLinkedList myLinkedList = new MyLinkedList();
//myLinkedList.addAtHead(1);
//myLinkedList.addAtTail(3);
//myLinkedList.addAtIndex(1, 2);    // 链表变为 1->2->3
//myLinkedList.get(1);              // 返回 2
//myLinkedList.deleteAtIndex(1);    // 现在，链表变为 1->3
//myLinkedList.get(1);              // 返回 3
// 
//
// 
//
// 提示： 
//
// 
// 0 <= index, val <= 1000 
// 请不要使用内置的 LinkedList 库。 
// 调用 get、addAtHead、addAtTail、addAtIndex 和 deleteAtIndex 的次数不超过 2000 。 
// 
//
// Related Topics 设计 链表 👍 1027 👎 0


package leetcode.editor.cn;

/**
 * 设计链表
 *
 * @author lzb
 * @date 2024-06-20 00:30:23
 */


public class P707_DesignLinkedList {
    static class MyNode {
        int val;
        MyNode next;
        MyNode prev;

        public MyNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addAtHead(1);
        myLinkedList.addAtTail(3);
        myLinkedList.addAtIndex(1, 2);    // 链表变为 1->2->3
        myLinkedList.get(1);              // 返回 2
        myLinkedList.deleteAtIndex(1);    // 现在，链表变为 1->3
        myLinkedList.get(1);              // 返回 3
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    static class MyLinkedList {

        int size;
        MyNode head;
        MyNode tail;

        public MyLinkedList() {
            size = 0;
            head = new MyNode(0);
            tail = new MyNode(0);
            head.next = tail;
            tail.prev = head;
        }

        public int get(int index) {
            if (index < 0 || index >= size)
                return -1;
            MyNode p;
            if (index + 1 < size - index) {
                p = head;
                for (int i = 0; i <= index; i++) {
                    p = p.next;
                }
            } else {
                p = tail;
                for (int i = 0; i < size - index; i++) {
                    p = p.prev;
                }
            }
            return p.val;
        }

        public void addAtHead(int val) {
            addAtIndex(0, val);
        }

        public void addAtTail(int val) {
            addAtIndex(size, val);
        }

        public void addAtIndex(int index, int val) {
            if (index > size) {
                return;
            }
            index = Math.max(0, index);
            // 前驱结点 后驱节点
            MyNode pred, succ;
            if (index < size - index) {
                pred = head;
                for (int i = 0; i < index; i++) {
                    pred = pred.next;
                }
                succ = pred.next;
            } else {
                succ = tail;
                for (int i = 0; i < size - index; i++) {
                    succ = succ.prev;
                }
                pred = succ.prev;
            }
            size++;
            MyNode newNode = new MyNode(val);
            newNode.prev = pred;
            newNode.next = succ;
            pred.next = newNode;
            succ.prev = newNode;
        }

        public void deleteAtIndex(int index) {
            if (index < 0 || index >= size)
                return;
            MyNode pred, succ;
            if (index < size - index) {
                pred = head;
                for (int i = 0; i < index; i++) {
                    pred = pred.next;
                }
                succ = pred.next.next;
            } else {
                succ = tail;
                for (int i = 0; i < size - index - 1; i++) {
                    succ = succ.prev;
                }
                pred = succ.prev.prev;
            }
            size--;
            pred.next = succ;
            succ.prev = pred;
        }
    }

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
//leetcode submit region end(Prohibit modification and deletion)

}
