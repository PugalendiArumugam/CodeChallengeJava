package LeetCode;

public class SameTreeEasy {
    public static void main(String[] args) {

        //q ={1,2,3} q={1,2,3) result true
//        TreeNode t1 = new TreeNode(1);
//        t1.left=new TreeNode(2);
//        t1.right=new TreeNode(3);
//
//        TreeNode t2 = new TreeNode(1);
//        t2.left=new TreeNode(2);
//        t2.right=new TreeNode(3);

        //q ={1,2} q={1,null,2) result false
        TreeNode t1 = new TreeNode(1);
        t1.left=new TreeNode(2);

        TreeNode t2 = new TreeNode(1);
        t2.right=new TreeNode(2);

//        //q ={1,2,1} q={1,1,2) result false
//        TreeNode t1 = new TreeNode(1);
//        t1.left=new TreeNode(2);
//        t1.right=new TreeNode(1);
//
//        TreeNode t2 = new TreeNode(1);
//        t2.left=new TreeNode(1);
//        t2.right=new TreeNode(2);


        System.out.println(isSameTree(t1,t2));
    }

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null && q==null) return true;

        if(p==null || q==null || p.val!=q.val) return false;

        return isSameTree(p.left,q.left) && isSameTree(p.right, q.right);
    }


}
