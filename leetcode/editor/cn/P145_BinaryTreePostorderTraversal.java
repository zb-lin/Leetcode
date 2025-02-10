//给你一棵二叉树的根节点 root ，返回其节点值的 后序遍历 。 
//
// 
//
// 示例 1： 
//
// 
// 输入：root = [1,null,2,3] 
// 
//
// 输出：[3,2,1] 
//
// 解释： 
//
// 
//
// 示例 2： 
//
// 
// 输入：root = [1,2,3,4,5,null,8,null,null,6,7,9] 
// 
//
// 输出：[4,6,7,5,2,9,8,3,1] 
//
// 解释： 
//
// 
//
// 示例 3： 
//
// 
// 输入：root = [] 
// 
//
// 输出：[] 
//
// 示例 4： 
//
// 
// 输入：root = [1] 
// 
//
// 输出：[1] 
//
// 
//
// 提示： 
//
// 
// 树中节点的数目在范围 [0, 100] 内 
// -100 <= Node.val <= 100 
// 
//
// 
//
// 进阶：递归算法很简单，你可以通过迭代算法完成吗？ 
//
// Related Topics 栈 树 深度优先搜索 二叉树 👍 1194 👎 0


package leetcode.editor.cn;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 二叉树的后序遍历
 *
 * @author lzb
 * @date 2024-09-09 13:17:41
 */
public class P145_BinaryTreePostorderTraversal {
    public static void main(String[] args) {
        Solution solution = new P145_BinaryTreePostorderTraversal().new Solution();
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
        public List<Integer> postorderTraversal(TreeNode root) {
            List<Integer> result = new LinkedList<>();
            Deque<TreeNode> deque = new LinkedList<>();
            if (root != null) {
                deque.push(root);
            }
            while (!deque.isEmpty()) {
                TreeNode node = deque.poll();
                if (node != null) {
                    deque.push(node);
                    deque.push(null);
                    if (node.right != null) {
                        deque.push(node.right);
                    }
                    if (node.left != null) {
                        deque.push(node.left);
                    }
                } else {
                    node = deque.poll();
                    result.add(node.val);
                }
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
