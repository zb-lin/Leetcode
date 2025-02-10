//给定两个整数数组 preorder 和 inorder ，其中 preorder 是二叉树的先序遍历， inorder 是同一棵树的中序遍历，请构造二叉树并
//返回其根节点。 
//
// 
//
// 示例 1: 
// 
// 
//输入: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
//输出: [3,9,20,null,null,15,7]
// 
//
// 示例 2: 
//
// 
//输入: preorder = [-1], inorder = [-1]
//输出: [-1]
// 
//
// 
//
// 提示: 
//
// 
// 1 <= preorder.length <= 3000 
// inorder.length == preorder.length 
// -3000 <= preorder[i], inorder[i] <= 3000 
// preorder 和 inorder 均 无重复 元素 
// inorder 均出现在 preorder 
// preorder 保证 为二叉树的前序遍历序列 
// inorder 保证 为二叉树的中序遍历序列 
// 
//
// Related Topics 树 数组 哈希表 分治 二叉树 👍 2308 👎 0


package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

/**
 * 从前序与中序遍历序列构造二叉树
 *
 * @author lzb
 * @date 2024-06-10 22:17:46
 */
public class P105_ConstructBinaryTreeFromPreorderAndInorderTraversal {
    public static void main(String[] args) {
        Solution solution = new P105_ConstructBinaryTreeFromPreorderAndInorderTraversal().new Solution();
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
        Map<Integer, Integer> cache = new HashMap<>();

        public TreeNode buildTree(int[] preorder, int[] inorder) {
            for (int i = 0; i < inorder.length; i++) {
                cache.put(inorder[i], i);
            }
            return buildTree(preorder, inorder, 0, preorder.length, 0, inorder.length);
        }

        public TreeNode buildTree(int[] preorder, int[] inorder, int preLeft, int preRight, int inLeft, int inRight) {
            if (preLeft >= preRight || inLeft >= inRight) return null;
            int rootIndex = cache.get(preorder[preLeft]);
            TreeNode node = new TreeNode(inorder[rootIndex]);
            int leftOfIndex = rootIndex - inLeft;
            node.left = buildTree(preorder, inorder,
                    preLeft + 1, preLeft + leftOfIndex + 1, inLeft, rootIndex);
            node.right = buildTree(preorder, inorder,
                    preLeft + leftOfIndex + 1, preRight, rootIndex + 1, inRight);
            return node;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
