package LeetCode.Easy;

/*
Input: root = [1,2,2,3,4,4,3]
Output: true

Input: root = [1,2,2,null,3,null,3]
Output: false
 */

public class SymmetricTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left=new TreeNode(2);
        root.right=new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left=new TreeNode(4);
        root.right.right=new TreeNode(3);

//        TreeNode root = new TreeNode(3);
//        root.left=new TreeNode(9);
//        root.right=new TreeNode(20);
//        root.right.left=new TreeNode(15);
//        root.right.right=new TreeNode(7);
        System.out.println(isSymmetric(root));
    }


    public static boolean isSymmetric(TreeNode root) {
        System.out.println(root.val);
        return  checkNode(root.left, root.right);
    }

    public static boolean checkNode(TreeNode lnode, TreeNode rnode){

        if(lnode==null && rnode==null) return true;


        if(lnode==null || rnode == null || lnode.val!=rnode.val) {
            return false;
        }

        System.out.println("L"+lnode.val+" R"+rnode.val);

        boolean chkLeft  = checkNode(lnode.left,rnode.right);
        boolean chkright = checkNode(lnode.right,rnode.left);

        return chkLeft && chkright;

    }
}
