//给你一个含重复值的二叉搜索树（BST）的根节点 root ，找出并返回 BST 中的所有 众数（即，出现频率最高的元素）。 
//
// 如果树中有不止一个众数，可以按 任意顺序 返回。 
//
// 假定 BST 满足如下定义： 
//
// 
// 结点左子树中所含节点的值 小于等于 当前节点的值 
// 结点右子树中所含节点的值 大于等于 当前节点的值 
// 左子树和右子树都是二叉搜索树 
// 
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [1,null,2,2]
//输出：[2]
// 
//
// 示例 2： 
//
// 
//输入：root = [0]
//输出：[0]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点的数目在范围 [1, 10⁴] 内 
// -10⁵ <= Node.val <= 10⁵ 
// 
//
// 
//
// 进阶：你可以不使用额外的空间吗？（假设由递归产生的隐式调用栈的开销不被计算在内） 
//
// Related Topics 树 深度优先搜索 二叉搜索树 二叉树 👍 756 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉搜索树中的众数
 *
 * @author lzb
 * @date 2024-06-25 22:05:49
 */
public class P501_FindModeInBinarySearchTree {
    public static void main(String[] args) {
        Solution solution = new P501_FindModeInBinarySearchTree().new Solution();
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

        List<Integer> resList = new ArrayList<>();
        int count = 0;
        TreeNode prev = null;
        int maxCount = 0;

        public int[] findMode(TreeNode root) {
            findMode1(root);
            int[] res = new int[resList.size()];
            for (int i = 0; i < resList.size(); i++) {
                res[i] = resList.get(i);
            }
            return res;
        }

        public void findMode1(TreeNode root) {
            if (root == null) return;
            findMode1(root.left);
            int rootVal = root.val;
            if (prev == null || rootVal != prev.val) {
                count = 1;
            } else {
                count++;
            }
            if (count > maxCount) {
                resList.clear();
                resList.add(rootVal);
                maxCount = count;
            } else if (count == maxCount) {
                resList.add(rootVal);
            }
            prev = root;
            findMode1(root.right);
        }




        /*public int[] findMode(TreeNode root) {
            Map<Integer, Integer> map = new HashMap<>();
            search(root, map);
            List<Map.Entry<Integer, Integer>> entries = map.entrySet().stream()
                    .sorted((a, b) -> b.getValue() - a.getValue()).collect(Collectors.toList());
            System.out.println(entries);
            List<Integer> res = new ArrayList<>();
            res.add(entries.get(0).getKey());
            for (int i = 1; i < entries.size(); i++) {
                if (Objects.equals(entries.get(i).getValue(), entries.get(i - 1).getValue())) {
                    res.add(entries.get(i).getKey());
                } else {
                    break;
                }
            }
            return res.stream().mapToInt(Integer::valueOf).toArray();
        }

        public void search(TreeNode root, Map<Integer, Integer> map) {
            if (root == null) return;
            map.put(root.val, map.getOrDefault(root.val, 0) + 1);
            search(root.left, map);
            search(root.right, map);
        }*/
    }
//leetcode submit region end(Prohibit modification and deletion)

}
