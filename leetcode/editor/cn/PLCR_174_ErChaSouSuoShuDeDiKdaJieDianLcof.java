//某公司组织架构以二叉搜索树形式记录，节点值为处于该职位的员工编号。请返回第 cnt 大的员工编号。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：root = [7, 3, 9, 1, 5], cnt = 2
//       7
//      / \
//     3   9
//    / \
//   1   5
//输出：7
// 
//
// 示例 2： 
//
// 
//
// 
//输入: root = [10, 5, 15, 2, 7, null, 20, 1, null, 6, 8], cnt = 4
//       10
//      / \
//     5   15
//    / \    \
//   2   7    20
//  /   / \ 
// 1   6   8
//输出: 8 
//
// 
//
// 提示： 
//
// 
// 1 ≤ cnt ≤ 二叉搜索树元素个数 
// 
//
// 
//
// Related Topics 树 深度优先搜索 二叉搜索树 二叉树 👍 421 👎 0


package leetcode.editor.cn;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 寻找二叉搜索树中的目标节点
 *
 * @author lzb
 * @date 2024-09-09 14:36:55
 */
public class PLCR_174_ErChaSouSuoShuDeDiKdaJieDianLcof {
    public static void main(String[] args) {
        Solution solution = new PLCR_174_ErChaSouSuoShuDeDiKdaJieDianLcof().new Solution();
        TreeNode n1 = new TreeNode(7);
        TreeNode n2 = new TreeNode(3);
        TreeNode n3 = new TreeNode(9);
        TreeNode n4 = new TreeNode(1);
        TreeNode n5 = new TreeNode(5);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        System.out.println();
        System.out.println(solution.findTargetNode(n1, 2));
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
        public int findTargetNode(TreeNode root, int cnt) {
            Deque<TreeNode> deque = new LinkedList<>();
            if (root != null) deque.push(root);
            while (!deque.isEmpty()) {
                TreeNode node = deque.poll();
                if (node != null) {
                    if (node.left != null) deque.push(node.left);
                    deque.push(node);
                    deque.push(null);
                    if (node.right != null) deque.push(node.right);

                } else {
                    node = deque.poll();
                    if (--cnt == 0) return node.val;
                }
            }
            return -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
