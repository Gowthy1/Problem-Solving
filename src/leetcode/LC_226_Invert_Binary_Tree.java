package leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given the root of a binary tree, invert the tree, and return its root.
 *
 * Example 1:
 * Input: root = [4,2,7,1,3,6,9]
 * Output: [4,7,2,9,6,3,1]
 *
 *  Example 2:
 * Input: root = [2,1,3]
 * Output: [2,3,1]
 *
 * Example 3:
 * Input: root = []
 * Output: []
 *
 * Constraints:
 * The number of nodes in the tree is in the range [0, 100].
 * -100 <= Node.val <= 100
 */
public class LC_226_Invert_Binary_Tree {
      //Definition for a binary tree node.
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
}
    private void dfs(TreeNode node){
        if(node == null) return;
        dfs(node.left);
        dfs(node.right);
        TreeNode temp = node.left;
        node.left = node.right;
        node.right = temp;
    }

    public TreeNode invertTree(TreeNode root) {
        if(root == null) return root;

        // Solution 1: With helper
        // dfs(root);

        //Solution 2: Without helper
        // if(root == null) return null;
        // TreeNode left  = invertTree(root.left);
        // TreeNode right = invertTree(root.right);
        // root.left  = right;
        // root.right = left;

        // Solution 3: BFS Iterative
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            TreeNode current = q.poll();

            TreeNode temp = current.left;
            current.left  = current.right;
            current.right = temp;

            if(current.left != null)
                q.offer(current.left);
            if(current.right != null)
                q.offer(current.right);
        }
        return root;
    }
}
