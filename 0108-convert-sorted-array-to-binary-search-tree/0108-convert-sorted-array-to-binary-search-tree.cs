/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left;
 *     public TreeNode right;
 *     public TreeNode(int val=0, TreeNode left=null, TreeNode right=null) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
public class Solution {
    public TreeNode SortedArrayToBST(int[] nums) {
        if(nums.Length==0){
            return null;
        }
        int mid = nums.Length/2;
        TreeNode root = new TreeNode(nums[mid]);
        if(nums.Length==1){
            return root;
        }
        root.left = SortedArrayToBST(nums[0..mid]);
        root.right = SortedArrayToBST(nums[(mid+1)..]);
        return root;
    }
}