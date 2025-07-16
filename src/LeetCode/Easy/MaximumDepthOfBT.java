package LeetCode.Easy;

public class MaximumDepthOfBT {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left=new TreeNode(2);
        root.right=new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.left.right= new TreeNode(9);
        root.left.left.right.right= new TreeNode(10);
        root.right.left=new TreeNode(5);
        root.right.left.left=new TreeNode(8);
        root.right.right=new TreeNode(6);
        root.right.right.right=new TreeNode(7);
        root.right.right.right.right=new TreeNode(9);

//        TreeNode root = new TreeNode(1);
//        root.left=new TreeNode(2);
//        root.right=new TreeNode(3);
//        root.left.left=new TreeNode(4);
//        root.left.right=new TreeNode(5);
//        root.right.left=new TreeNode(6);
//        root.right.right=new TreeNode(7);


//        TreeNode root = new TreeNode(1);
//        root.right=new TreeNode(2);

        System.out.println(maxDepth(root));
    }

    public static int maxDepth(TreeNode root) {
        if(root!=null){
            System.out.println("Entry");
            System.out.println("Top:"+root.val) ;
        } else System.out.println("Null entry");
        if(root==null) return 0;

        int leftDepth = maxDepth(root.left);

        int rightDepth = maxDepth(root.right);

        System.out.println("bottom:"+root.val) ;
//        System.out.println("Root:"+root.val+" left "+leftDepth+" right "+ rightDepth);
        return 1 + (Math.min(leftDepth, rightDepth));
    }
}
