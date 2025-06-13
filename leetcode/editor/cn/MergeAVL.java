package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * 合并两个平衡搜索树为一个 平衡搜索树 (时间复杂度为O(h1 + h2)) t1 的所有值小于 t2 的所有值
 */
public class MergeAVL {

    List<Integer> res = new ArrayList<>();

    public void tra(TreeNode root) {
        if (root == null) return;
        tra(root.left);
        res.add(root.val);
        tra(root.right);
    }

    public TreeNode getTree(List<Integer> nums, int left, int right) {
        if (left > right) return null;
        int mid = (left + right) / 2;
        TreeNode root = new TreeNode(nums.get(mid));
        root.left = getTree(nums, left, mid - 1);
        root.right = getTree(nums, mid + 1, right);
        return root;
    }

    public TreeNode mergeAVL(TreeNode root1, TreeNode root2) {
        TreeNode node = root2;
        while (node.left != null) {
            node = node.left;
        }
        node.left = root1;
        tra(root2);
        return  getTree(res, 0, res.size() - 1);
    }

    // 辅助方法：打印二叉树（中序遍历）
    public void printInOrder(TreeNode root) {
        if (root == null) return;
        printInOrder(root.left);
        System.out.print(root.val + " ");
        printInOrder(root.right);
    }


    public static void main(String[] args) {
        MergeAVL solution = new MergeAVL();

        // 测试用例1：构造两个平衡搜索树
        // 树1: [1, 2, 3] （所有值都小于树2）
        TreeNode root1 = new TreeNode(2);
        root1.left = new TreeNode(1);
        root1.right = new TreeNode(3);

        // 树2: [4, 5, 6]
        TreeNode root2 = new TreeNode(5);
        root2.left = new TreeNode(4);
        root2.right = new TreeNode(6);

        // 合并两个树
        TreeNode mergedTree = solution.mergeAVL(root1, root2);

        System.out.println("合并后的树 (中序遍历):");
        solution.printInOrder(mergedTree);
    }
}
