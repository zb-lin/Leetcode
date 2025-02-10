//给你一棵二叉树的根节点
// root ，请你判断这棵树是否是一棵 完全二叉树 。 
//
// 在一棵 完全二叉树 中，除了最后一层外，所有层都被完全填满，并且最后一层中的所有节点都尽可能靠左。最后一层（第 h 层）中可以包含
// 1 到
// 2ʰ 个节点。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：root = [1,2,3,4,5,6]
//输出：true
//解释：最后一层前的每一层都是满的（即，节点值为 {1} 和 {2,3} 的两层），且最后一层中的所有节点（{4,5,6}）尽可能靠左。
// 
//
// 示例 2： 
//
// 
//
// 
//输入：root = [1,2,3,4,5,null,7]
//输出：false
//解释：值为 7 的节点不满足条件「节点尽可能靠左」。
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [1, 100] 内 
// 1 <= Node.val <= 1000 
// 
//
// Related Topics 树 广度优先搜索 二叉树 👍 292 👎 0


package leetcode.editor.cn;

import javafx.util.Pair;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 二叉树的完全性检验
 *
 * @author lzb
 * @date 2024-09-07 14:25:17
 */
public class P958_CheckCompletenessOfABinaryTree {
    public static void main(String[] args) {
        Solution solution = new P958_CheckCompletenessOfABinaryTree().new Solution();
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
        public boolean isCompleteTree(TreeNode root) {
            Deque<Pair<TreeNode, Integer>> deque = new LinkedList<>();
            if (root != null) deque.addFirst(new Pair<>(root, 1));
            int pre = -1;
            boolean flag = true;
            while (!deque.isEmpty() && flag) {
                int size = deque.size();
                for (int i = 0; i < size; i++) {
                    Pair<TreeNode, Integer> pair = deque.removeFirst();
                    TreeNode node = pair.getKey();
                    Integer idx = pair.getValue();
                    if (pre == -1 || pre == idx - 1) {
                        pre = idx;
                    } else if (pre != idx - 1) {
                        flag = false;
                        break;
                    }
                    if (node.left != null) deque.addLast(new Pair<>(node.left, idx * 2));
                    if (node.right != null) deque.addLast(new Pair<>(node.right, idx * 2 + 1));
                }
            }
            return flag;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
