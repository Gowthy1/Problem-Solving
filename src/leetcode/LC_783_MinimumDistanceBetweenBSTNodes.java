package leetcode;

import java.util.ArrayList;

/**
 * Given the root of a Binary Search Tree (BST), return the minimum difference between the values of any two different nodes in the tree.
 *
 * Example 1:
 * Input: root = [4,2,6,1,3]
 * Output: 1
 *
 *  Example 2:
 * Input: root = [1,0,48,null,null,12,49]
 * Output: 1
 *
 * Constraints:
 * The number of nodes in the tree is in the range [2, 100].
 * 0 <= Node.val <= 105
 */
public class LC_783_MinimumDistanceBetweenBSTNodes {
    // Definition for a binary tree node.
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

    //Approach 1: using Array to calculate difference
    ArrayList<Integer> list = new ArrayList<>();
    private void dfsApproach1(TreeNode node){
        if(node == null) return;

        dfsApproach1(node.left);
        list.add(node.val); // Inorder traversal to have to preservce the increasing order of elements
        dfsApproach1(node.right);
    }

    public int minDiffInBSTApproach1(TreeNode root) {
        dfs(root);
        System.out.println(list);
        int min=Integer.MAX_VALUE;
        for(int i=0; i<list.size()-1; i++){
            min = Math.min(Math.abs(list.get(i)-list.get(i+1)), min);
        }
        return min;
    }

    // Approach 2: Calculation Without array
    TreeNode prevNode = null;
    int min =Integer.MAX_VALUE;
    private void dfs(TreeNode node){
        if(node == null) return;

        dfs(node.left);

        if(prevNode!=null){
            min = Math.min(Math.abs(node.val - prevNode.val), min);
        }
        prevNode = node;
        dfs(node.right);
    }

    public int minDiffInBST(TreeNode root) {
        dfs(root);
        return min;
    }
}
