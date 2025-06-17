//给你一棵二叉树的根节点 root ，返回树的 最大宽度 。 
//
// 树的 最大宽度 是所有层中最大的 宽度 。 
//
// 
// 
// 每一层的 宽度 被定义为该层最左和最右的非空节点（即，两个端点）之间的长度。将这个二叉树视作与满二叉树结构相同，两端点间会出现一些延伸到这一层的 
//null 节点，这些 null 节点也计入长度。 
// 
// 
//
// 题目数据保证答案将会在 32 位 带符号整数范围内。 
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [1,3,2,5,3,null,9]
//输出：4
//解释：最大宽度出现在树的第 3 层，宽度为 4 (5,3,null,9) 。
// 
//
// 示例 2： 
// 
// 
//输入：root = [1,3,2,5,null,null,9,6,null,7]
//输出：7
//解释：最大宽度出现在树的第 4 层，宽度为 7 (6,null,null,null,null,null,7) 。
// 
//
// 示例 3： 
// 
// 
//输入：root = [1,3,2,5]
//输出：2
//解释：最大宽度出现在树的第 2 层，宽度为 2 (3,2) 。
// 
//
// 
//
// 提示： 
//
// 
// 树中节点的数目范围是 [1, 3000] 
// -100 <= Node.val <= 100 
// 
//
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 699 👎 0


package leetcode.editor.cn;

import javafx.util.Pair;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 二叉树最大宽度
 * @author lzb
 * @date 2025-06-15 21:37:56
 */
public class P662_MaximumWidthOfBinaryTree{
	 public static void main(String[] args) {
	 	 Solution solution = new P662_MaximumWidthOfBinaryTree().new Solution();
	 }
	 

//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        int res = 1;
		if (root == null) return 0;
		Deque<Pair<TreeNode, Integer>> deque = new LinkedList<>();
		deque.add(new Pair<>(root, 1));
		while (!deque.isEmpty()) {
			int len = deque.size();
			int min = 0, max = 0;
			for (int i = 0; i < len; ++i) {
				Pair<TreeNode, Integer> pair = deque.removeFirst();
				TreeNode node = pair.getKey();
				if (node.left != null) deque.addLast(new Pair<>(node.left, pair.getValue() * 2));
				if (node.right != null) deque.addLast(new Pair<>(node.right, pair.getValue() * 2 + 1));
				if (i == 0) min = pair.getValue();
				if (i == len - 1) max = pair.getValue();
			}
			res = Math.max(res, max - min + 1);
		}
		return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
