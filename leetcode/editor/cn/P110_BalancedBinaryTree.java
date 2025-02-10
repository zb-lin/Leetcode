//给定一个二叉树，判断它是否是 平衡二叉树 
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [3,9,20,null,null,15,7]
//输出：true
// 
//
// 示例 2： 
// 
// 
//输入：root = [1,2,2,3,3,null,null,4,4]
//输出：false
// 
//
// 示例 3： 
//
// 
//输入：root = []
//输出：true
// 
//
// 
//
// 提示： 
//
// 
// 树中的节点数在范围 [0, 5000] 内 
// -10⁴ <= Node.val <= 10⁴ 
// 
//
// Related Topics 树 深度优先搜索 二叉树 👍 1523 👎 0


package leetcode.editor.cn;

/**
 * 平衡二叉树
 *
 * @author lzb
 * @date 2024-06-24 20:01:44
 */
public class P110_BalancedBinaryTree {
    public static void main(String[] args) {
        Solution solution = new P110_BalancedBinaryTree().new Solution();
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

        public int getHeight(TreeNode root) {
            if (root == null) return 0;
            int leftHeight = getHeight(root.left);
            if (leftHeight == -1) return -1;
            int rightHeight = getHeight(root.right);
            if (rightHeight == -1) return -1;
            if (Math.abs(rightHeight - leftHeight) > 1) {
                return -1;
            }
            return 1 + Math.max(rightHeight, leftHeight);
        }

        public boolean isBalanced(TreeNode root) {
            return getHeight(root) != -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
