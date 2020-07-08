/* PROBLEM:
Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its bottom-up level order traversal as:
[
  [15,7],
  [9,20],
  [3]
]
*/

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

import java.util.*;
class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        Queue<TreeNode> q= new LinkedList<TreeNode>();
        q.add(root);
        q.add(null);
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        ArrayList<Integer> tempList = new ArrayList<Integer>();
        if(root==null) return res;
        while(!q.isEmpty()){
            TreeNode temp = q.poll();
            if(temp!=null){
                tempList.add(temp.val);
                if(temp.left!=null) q.add(temp.left);
                if(temp.right!=null) q.add(temp.right);
            }else{
                res.add(tempList);
                tempList = new ArrayList<Integer>();
                if(!q.isEmpty()) q.add(null);
                else break;
            }
        }
        Collections.reverse(res);
        return res;
    }
}
