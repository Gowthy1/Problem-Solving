package LeetCode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given the root of a binary tree, return the zigzag level order traversal of its nodes' values. (i.e., from left to right, then right to left for the next level and alternate between).
 * <p>
 * Example 1:
 * Input: root = [3,9,20,null,null,15,7]
 * Output: [[3],[20,9],[15,7]]
 * <p>
 * Example 2:
 * Input: root = [1]
 * Output: [[1]]
 * <p>
 * Example 3:
 * Input: root = []
 * Output: []
 * <p>
 * Constraints:
 * The number of nodes in the tree is in the range [0, 2000].
 * -100 <= Node.val <= 100
 */
public class LC_103_BinaryTreeZigzagLevelOrderTraversal {
    // Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


    private void bfs(TreeNode root, List<List<Integer>> res) {
        boolean right = false;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            LinkedList<Integer> list = new LinkedList<>();
            int size = q.size();
            right = !right;
            while (size-- > 0) {
                TreeNode node = q.poll();

                if (node.left != null)
                    q.offer(node.left);
                if (node.right != null)
                    q.offer(node.right);

                if (right) {
                    list.add(node.val);
                } else {
                    list.add(0, node.val);
                }
            }
            res.add(new LinkedList<>(list));
        }
    }

    private void dfs(TreeNode node, List<List<Integer>> res, int level) {
        if (node == null) return;

        if (res.size() <= level) // THis is true, when we didn't reach this level from root
        {
            res.add(new LinkedList<>());
        }

        List<Integer> currLevelResult = res.get(level);
        if (level % 2 == 0) 
            currLevelResult.add(node.val);
        else 
            currLevelResult.add(0, node.val);

        dfs(node.left, res, level + 1);
        dfs(node.right, res, level + 1);
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        if (root == null) return res;
        // Approach 1: BFS
        bfs(root, res);
        // Approach 2: DFS
        dfs(root, res, 0);
        return res;
    }
}
