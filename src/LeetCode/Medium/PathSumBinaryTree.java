package LeetCode.Medium;

import LeetCode.Medium.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/*
[1,-2,-3,1,3,-2,null,-1]
Target = 2
Expected
[[1,-2,3]]
failed with giving [[-2,1,3]]

 */


public class PathSumBinaryTree {
    public static void main(String[] args) {

        PathSumBinaryTree obj= new PathSumBinaryTree();

//        TreeNode root = new TreeNode(1);
//        root.left=new TreeNode(2);
//        root.right=new TreeNode(3);
//        root.left.left=new TreeNode(4);
//        root.left.right=new TreeNode(5);
//        root.left.right.right=new TreeNode(6);
//        root.right.left=new TreeNode(6);
//        root.right.right=new TreeNode(7);
//        root.right.right.right=new TreeNode(3);

// [1,-2,-3,1,3,-2,null,-1]  tgt 2 expected [[1,-2,3]]

        TreeNode root = new TreeNode(1);
        root.left=new TreeNode(-2);
        root.right=new TreeNode(-3);
        root.left.left=new TreeNode(1);
        root.left.right=new TreeNode(3);
        root.right.left=new TreeNode(-2);
        root.right.left.left=new TreeNode(-1);


 //        TreeNode root = new TreeNode(1);
//        root.left=new TreeNode(2);
//        root.right=new TreeNode(3);

        System.out.println(obj.hasPathSum(root,2));


    }

    public List<List<Integer>> hasPathSum(TreeNode root, int targetSum) {
        int sum=0;
        int rootval=0;
        List<List<Integer>> res = new ArrayList<>();
        if(root==null) {
            return res;
        }
        rootval=root.val;
//        List<Integer> curr = new ArrayList<>();
        Stack<Integer> curr = new Stack<>();
        res = checkSum(root, targetSum,res ,sum, rootval, curr);
        return res;
    }

    public List<List<Integer>>  checkSum(TreeNode root, int targetSum, List<List<Integer>> res, int sum, int rootval, Stack<Integer> curr){
//        if (root==null) {
//            System.out.println("Null ---------------");
//        } else {
//            System.out.println("Not Null --------------- "+root.val);
//        }
        if(root==null) return res;
        sum+=root.val;
//        curr.add(root.val);
        curr.add(root.val);
        System.out.println(Arrays.toString(curr.toArray()));
        if(root.left==null && root.right==null){
            if(sum==targetSum){
                System.out.println("**** Matched **** Sum:"+sum+" Target:"+targetSum);
//                res=true;
//                res.add(curr);
                List<Integer> temp = new ArrayList<>(curr);
                res.add(temp);
//                curr=new ArrayList<>();
//                curr.add(rootval);
                sum=rootval;
//                return res;
            }
        }
//        System.out.println(root.val+" result:"+res+" sum:"+sum);
        res = checkSum(root.left,targetSum,res,sum,rootval,curr);
//        System.out.println("After left val:"+root.val);
        res = checkSum(root.right,targetSum,res,sum,rootval,curr);
//        System.out.println("After right val:"+root.val);
//        System.out.println("Bottom val"+root.val);
        sum-=root.val;
//        curr.remove((Integer) root.val);
        curr.pop();
        return res;
    }
}
