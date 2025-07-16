package LeetCode.Easy;


/* 222
Count Complete Tree Nodes

Example 1:
Input: root = [1,2,3,4,5,6]
Output: 6

Example 2:
Input: root = []
Output: 0

Example 3:
Input: root = [1]
Output: 1
 */
public class CountTreeNodes {
    public static void main(String[] args) {
        CountTreeNodes ctn = new CountTreeNodes();

        TreeNode root = new TreeNode(1);
        root.left=new TreeNode(2);
        root.right=new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left=new TreeNode(6);
        System.out.println(ctn.countNodes(root));
    }

    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int l = countTree(root.left);
        int r = countTree(root.right);
        if (l == r){
            return (1 << l) + countNodes(root.right);
        } else {
            return (1 << r) + countNodes(root.left);
        }
    }

    private int countTree(TreeNode root) {
        int count = 0;
        for (; root != null; root = root.left) {
            count++;
        }
        return count;
    }
}
