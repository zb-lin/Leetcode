//给你二叉树的根节点 root ，返回其节点值的 锯齿形层序遍历 。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
//
//
//
// 示例 1：
//
//
//输入：root = [3,9,20,null,null,15,7]
//输出：[[3],[20,9],[15,7]]
//
//
// 示例 2：
//
//
//输入：root = [1]
//输出：[[1]]
//
//
// 示例 3：
//
//
//输入：root = []
//输出：[]
//
//
//
//
// 提示：
//
//
// 树中节点数目在范围 [0, 2000] 内
// -100 <= Node.val <= 100
//
//
// Related Topics 树 广度优先搜索 二叉树 👍 895 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 二叉树的锯齿形层序遍历
 *
 * @author lzb
 * @date 2024-06-11 10:41:58
 */
public class P103_BinaryTreeZigzagLevelOrderTraversal {
    public static void main(String[] args) {
        Solution solution = new P103_BinaryTreeZigzagLevelOrderTraversal().new Solution();
    }


//leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    class Solution {
        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
            List<List<Integer>> result = new ArrayList<>();
            if (root == null) return result;
            boolean flag = true;
            Deque<TreeNode> deque = new LinkedList<>();
            deque.addFirst(root);
            while (!deque.isEmpty()) {
                int len = deque.size();
                List<Integer> itemList = new ArrayList<>();
                for (int i = 0; i < len; ++i) {
                    if (flag) {
                        TreeNode node = deque.removeFirst();
                        itemList.add(node.val);
                        if (node.left != null) deque.addLast(node.left);
                        if (node.right != null) deque.addLast(node.right);
                    } else {
                        TreeNode node = deque.removeLast();
                        itemList.add(node.val);
                        if (node.right != null) deque.addFirst(node.right);
                        if (node.left != null) deque.addFirst(node.left);
                    }
                }
                result.add(itemList);
                flag = !flag;
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
