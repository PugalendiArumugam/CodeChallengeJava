package LeetCode.Easy;

public class MinimumDepthBinTreeII {

    public static void main(String[] args) {
        MinimumDepthBinTreeII sol = new MinimumDepthBinTreeII();
        TreeNode root = new TreeNode(1);
        root.left=new TreeNode(2);
        root.right=new TreeNode(3);
//        root.left.left = new TreeNode(4);
//        root.left.left.right= new TreeNode(9);
//        root.left.left.right.right= new TreeNode(10);
//        root.right.left=new TreeNode(5);
//        root.right.left.left=new TreeNode(8);
        root.right.right=new TreeNode(6);
        root.right.right.right=new TreeNode(7);
        root.right.right.right.right=new TreeNode(9);
        System.out.println(sol.minDepth(root));
    }

    public int level = 0, min = Integer.MAX_VALUE;

    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        getMin(root);
        return min;
    }

    public void getMin(TreeNode root) {
        ++level;
        if (level == min) {
            --level;
            return;
        }
        if (root.left == null && root.right == null) {
            min = Math.min(level, min);
            --level;
            return;
        }
        if ((root.left != null) && (root.right == null || root.right.right != null || root.right.left != null)) getMin(root.left);
        if (root.right != null) getMin(root.right);
        --level;
    }

}

