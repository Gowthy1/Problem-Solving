package leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given the root of a binary tree, return its maximum depth.
 * A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 *
 * Example 1:
 * Input: root = [3,9,20,null,null,15,7]
 * Output: 3
 *
 * Example 2:
 * Input: root = [1,null,2]
 * Output: 2
 *
 * Constraints:
 * The number of nodes in the tree is in the range [0, 104].
 * -100 <= Node.val <= 100
 */
public class LC_104_MaximumDepthOfBinaryTree {

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
    private int max = 0;

    class Pair {
        int level;
        TreeNode node;
        Pair(TreeNode node, int level){
            this.node = node;
            this.level = level;
        }
    }

    private void dfs(TreeNode root, int level){
        if(root == null){
            max = Math.max(max, level);
            return;
        }

        dfs(root.left, level + 1);
        dfs(root.right, level + 1);
    }

    private void bfs(TreeNode root){
        if(root == null)
            return;
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(root, 1));
        while(!q.isEmpty()){
            int size = q.size();
            while(size-- > 0){
                Pair p = q.poll();
                if(p.node.left != null){
                    q.offer(new Pair(p.node.left, p.level+1));
                }
                if(p.node.right != null){
                    q.offer(new Pair(p.node.right, p.level+1));
                }
                max = Math.max(p.level, max);
            }
        }
    }

    private int bfsSolution(TreeNode root){
        if(root == null)
            return 0;
        Queue<TreeNode> q = new LinkedList<>();
        int count = 0;
        q.offer(root);
        while(!q.isEmpty()){
            int size = q.size();
            while(size-- > 0){
                TreeNode node = q.poll();
                assert node != null;
                if(node.left != null){
                    q.offer(node.left);
                }
                if(node.right != null){
                    q.offer(node.right);
                }
            }
            count++;
        }
        return count;
    }

    public int maxDepth(TreeNode root) {
        // Both DFS and BFS
        dfs(root, 0);
        bfs(root);
        max = bfsSolution(root);
        return max;
    }
}
