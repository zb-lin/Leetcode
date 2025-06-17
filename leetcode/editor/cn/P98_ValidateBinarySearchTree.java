//给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。 
//
// 有效 二叉搜索树定义如下： 
//
// 
// 节点的左子树只包含 小于 当前节点的数。 
// 节点的右子树只包含 大于 当前节点的数。 
// 所有左子树和右子树自身必须也是二叉搜索树。 
// 
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [2,1,3]
//输出：true
// 
//
// 示例 2： 
// 
// 
//输入：root = [5,1,4,null,null,3,6]
//输出：false
//解释：根节点的值是 5 ，但是右子节点的值是 4 。
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目范围在[1, 10⁴] 内 
// -2³¹ <= Node.val <= 2³¹ - 1 
// 
//
// Related Topics 树 深度优先搜索 二叉搜索树 二叉树 👍 2350 👎 0


package leetcode.editor.cn;

/**
 * 验证二叉搜索树
 *
 * @author lzb
 * @date 2024-06-10 22:14:13
 */
public class P98_ValidateBinarySearchTree {
    public static void main(String[] args) {
        Solution solution = new P98_ValidateBinarySearchTree().new Solution();
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
        // 前一个节点的值，初始为最小可能值
        long prev = Long.MIN_VALUE;

        public boolean isValidBST(TreeNode root) {
            // 空树是有效的BST
            if (root == null) {
                return true;
            }

            // 先验证左子树
            if (!isValidBST(root.left)) {
                return false;
            }

            // 检查当前节点值是否大于前一个节点值
            if (root.val <= prev) {
                return false;
            }

            // 更新前一个节点值为当前节点值
            prev = root.val;

            // 验证右子树
            return isValidBST(root.right);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
