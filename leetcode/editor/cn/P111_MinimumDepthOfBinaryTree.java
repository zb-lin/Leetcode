//给定一个二叉树，找出其最小深度。 
//
// 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。 
//
// 说明：叶子节点是指没有子节点的节点。 
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [3,9,20,null,null,15,7]
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：root = [2,null,3,null,4,null,5,null,6]
//输出：5
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数的范围在 [0, 10⁵] 内 
// -1000 <= Node.val <= 1000 
// 
//
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 1199 👎 0


package leetcode.editor.cn;

/**
 * 二叉树的最小深度
 *
 * @author lzb
 * @date 2024-06-24 19:47:51
 */
public class P111_MinimumDepthOfBinaryTree {
    public static void main(String[] args) {
        Solution solution = new P111_MinimumDepthOfBinaryTree().new Solution();
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
        public int minDepth(TreeNode root) {
            if (root == null) return 0;
            if (root.left == null && root.right != null) {
                return minDepth(root.right) + 1;
            }
            if (root.left != null && root.right == null) {
                return minDepth(root.left) + 1;
            }
            return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
