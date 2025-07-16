package LeetCode.Medium;

/*
98. Validate Binary Search Tree
Given the root of a binary tree, determine if it is a valid binary search tree (BST).
A valid BST is defined as follows:
The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.

Example 1:
Input: root = [2,1,3]
Output: true

Example 2:
Input: root = [5,1,4,null,null,3,6]
Output: false
Explanation: The root node's value is 5 but its right child's value is 4.
 */
public class ValidateBinaryTree {
    Integer rootval;

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(5);
        root1.left = new TreeNode(1);
        root1.right = new TreeNode(4);
        root1.right.left = new TreeNode(3);
        root1.right.right = new TreeNode(6);   //false

        TreeNode root2 = new TreeNode(5);
        root2.left = new TreeNode(1);
        root2.right = new TreeNode(8);
        root2.right.left = new TreeNode(7);
        root2.right.right = new TreeNode(9);   //true


        TreeNode root3 = new TreeNode(1);
        root3.left = new TreeNode(1);

        ValidateBinaryTree vbt = new ValidateBinaryTree();

        TreeNode root4 = new TreeNode(2);
        root4.left = new TreeNode(1);
        root4.right = new TreeNode(3);

//        System.out.println(vbt.isValidBST(root1));
        System.out.println(vbt.isValidBST(root2));
//        System.out.println(vbt.isValidBST(root3));
//        System.out.println(vbt.isValidBST(root4));
    }

    public boolean isValidBST(TreeNode root) {
        if(root.left==null && root.right==null) return true;
        rootval = null;
        System.out.println("------------");
        return checkNode(root);
    }


    private boolean checkNode(TreeNode root){

        if(root==null) return true;  // all left and right nodes are properly valued.

        System.out.println("rootval:"+rootval+" root.val"+root.val);

        if (!checkNode(root.left)) {
            return false;
        }


        if (rootval != null && rootval >= root.val) {
            return false;
        }


        System.out.println("rootval:"+rootval+" root.val"+root.val);

        if (!checkNode(root.right)) {
            return false;
        }
        return true;
    }
}
