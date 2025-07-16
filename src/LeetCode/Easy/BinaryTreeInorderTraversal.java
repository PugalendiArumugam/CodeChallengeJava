package LeetCode.Easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*
Given the root of a binary tree, return the inorder traversal of its nodes' values.

Example 1:
Input: root = [1,null,2,3]
Output: [1,3,2]

Example 2:
Input: root = [1,2,3,4,5,null,8,null,null,6,7,9]
Output: [4,2,6,5,7,1,3,9,8]

Example 3:
Input: root = []
Output: []

Example 4:
Input: root = [1]
Output: [1]
 */


public class BinaryTreeInorderTraversal {
    public static void main(String[] args) {
        BinaryTreeInorderTraversal bt = new BinaryTreeInorderTraversal();

//        TreeNode root = new TreeNode(1);
//        root.left=new TreeNode(2);
//        root.left.left=new TreeNode(4);
//        root.left.right=new TreeNode(5);
//        root.left.right.left=new TreeNode(6);
//        root.left.right.right=new TreeNode(7);
//        root.right=new TreeNode(3);
//        root.right.right=new TreeNode(8);
//        root.right.right.left=new TreeNode(9);

//        TreeNode root = new TreeNode(1);
//        root.right=new TreeNode(2);
//        root.right.left=new TreeNode(3);

        TreeNode root = new TreeNode(1);
        root.right=new TreeNode(0);
        root.right.left=new TreeNode(3);     // expected [1, 3, 0]


        System.out.println(Arrays.toString(bt.inorderTraversal(root).toArray()));
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root==null || root.val ==0) return result;
        result = treePath(root,result);
        return result;
    }

    public List<Integer> treePath(TreeNode root, List<Integer> result){
        if(root==null) return result;

        result = treePath(root.left,result);

        result.add(root.val);

        result = treePath(root.right, result);

        return result;
    }

}
