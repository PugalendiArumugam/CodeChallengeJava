package LeetCode.Easy;

public class MinimumDepthOfBT {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
//        root.left=new TreeNode(2);
        root.right=new TreeNode(3);
//        root.left.left = new TreeNode(4);
//        root.left.left.right= new TreeNode(9);
//        root.left.left.right.right= new TreeNode(10);
//        root.right.left=new TreeNode(5);
//        root.right.left.left=new TreeNode(8);
        root.right.right=new TreeNode(6);
        root.right.right.right=new TreeNode(7);
        root.right.right.right.right=new TreeNode(9);
        System.out.println(minDepth(root));
    }

    public static int minDepth(TreeNode root) {
        if(root!=null){
            System.out.println("Entry");
            System.out.println("Top:"+root.val) ;
        } else System.out.println("Null entry");

        if(root==null) return 0;

        if(root.left==null){
            return 1 + minDepth(root.right);
        }

        if(root.right==null) {
            return 1+ minDepth(root.left);
        }

        System.out.println("bottom:"+root.val) ;

        return 1 + Math.min(minDepth(root.left),minDepth(root.right));
    }
}
