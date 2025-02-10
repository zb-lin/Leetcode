//给你一个二叉树的根节点 root ，按 任意顺序 ，返回所有从根节点到叶子节点的路径。 
//
// 叶子节点 是指没有子节点的节点。 
//
// 示例 1： 
// 
// 
//输入：root = [1,2,3,null,5]
//输出：["1->2->5","1->3"]
// 
//
// 示例 2： 
//
// 
//输入：root = [1]
//输出：["1"]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点的数目在范围 [1, 100] 内 
// -100 <= Node.val <= 100 
// 
//
// Related Topics 树 深度优先搜索 字符串 回溯 二叉树 👍 1145 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树的所有路径
 *
 * @author lzb
 * @date 2024-06-24 20:13:10
 */
public class P257_BinaryTreePaths {
    public static void main(String[] args) {
        Solution solution = new P257_BinaryTreePaths().new Solution();
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
        List<String> res = new ArrayList<>();
        List<Integer> track = new ArrayList<>();

        public List<String> binaryTreePaths(TreeNode root) {
            if (root == null) return res;
            track.add(root.val);
            if (root.right == null && root.left == null) {
                StringBuilder sb = new StringBuilder();
                track.forEach(num -> {
                    sb.append(num).append("->");
                });
                sb.deleteCharAt(sb.length() - 1).deleteCharAt(sb.length() - 1);
                res.add(sb.toString());
            }
            binaryTreePaths(root.left);
            binaryTreePaths(root.right);
            track.remove(track.size() - 1);
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
