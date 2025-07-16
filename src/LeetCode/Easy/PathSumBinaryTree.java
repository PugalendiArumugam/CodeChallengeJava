package LeetCode.Easy;

public class PathSumBinaryTree {
    public static void main(String[] args) {

        PathSumBinaryTree obj= new PathSumBinaryTree();

//        TreeNode root = new TreeNode(1);
//        root.left=new TreeNode(2);
//        root.right=new TreeNode(3);
//        root.left.left = new TreeNode(4);
//        root.left.left.right= new TreeNode(9);
//        root.left.left.right.right= new TreeNode(10);
//        root.right.left=new TreeNode(5);
//        root.right.left.left=new TreeNode(8);
//        root.right.right=new TreeNode(6);
//        root.right.right.right=new TreeNode(7);
//        root.right.right.right.right=new TreeNode(9);

//        TreeNode root = new TreeNode(1);
//        root.left=new TreeNode(2);
//        root.right=new TreeNode(3);
//        root.left.left=new TreeNode(4);
//        root.left.right=new TreeNode(5);
//        root.right.left=new TreeNode(6);
//        root.right.right=new TreeNode(7);
//        root.right.right.right=new TreeNode(8);

        TreeNode root = new TreeNode(1);
        root.left=new TreeNode(2);
        root.right=new TreeNode(3);

        System.out.println(obj.hasPathSum(root,4));


    }

    public boolean hasPathSum(TreeNode root, int targetSum) {
        Integer sum=0;
        if(root==null) {
            return false;
        }
        return checkSum(root,targetSum,false,sum);
    }

    public boolean checkSum(TreeNode root, int targetSum, boolean res, Integer sum){
//        if (root==null) {
//            System.out.println("Null ---------------");
//        } else {
//            System.out.println("Not Null --------------- "+root.val);
//        }
        if(root==null) return res;
        sum+=root.val;
        if(root.left==null && root.right==null){
            if(sum==targetSum){
                System.out.println("**** Matched **** Sum:"+sum+" Target:"+targetSum);
                res=true;
                return res;
            }
        }
//        System.out.println(root.val+" result:"+res+" sum:"+sum);
        res=checkSum(root.left,targetSum,res,sum);
//        System.out.println("After left val:"+root.val);
        res=checkSum(root.right,targetSum,res,sum);
//        System.out.println("After right val:"+root.val);
//        System.out.println("Bottom val"+root.val);
        sum-=root.val;
        return res;
    }
}
