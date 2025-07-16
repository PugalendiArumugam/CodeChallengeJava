package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {
    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left=new TreeNode(2);
        root.right=new TreeNode(3);
        root.left.right = new TreeNode(5);

//        TreeNode root = new TreeNode(1);


        System.out.println(binaryTreePaths(root));
    }

    public static List<String> binaryTreePaths(TreeNode root) {

//        List<String> result = new ArrayList<>();
//        if(root==null) return result;
//        String current_path = Integer.toString(root.val);
//        if(root.left == null && root.right ==null) {
//            result.add(current_path);
//        }
//        if(root.left !=null) getPath(root.left, current_path,result);
//        if(root.right!=null) getPath(root.right,current_path,result);
//        return result;


        List<String> result = new ArrayList<>();
        if(root==null) return result;
        StringBuilder currentPath= new StringBuilder();
        getPath(root, currentPath,result);
        return result;
    }

    public static void getPath(TreeNode node, StringBuilder current_path, List<String> result){

//        current_path = current_path + "->"+node.val;
//        if(node.left == null && node.right ==null){
//            result.add(current_path);
//            return;
//        }
//        if(node.left !=null) getPath(node.left, current_path,result);
//        if(node.right!=null) getPath(node.right,current_path,result);
//        if(node == null) return;

        int len = current_path.length();

        current_path.append(node.val);

        if(node.left == null && node.right ==null){
            result.add(current_path.toString());
        } else {
            current_path.append("->");
            if(node.left !=null) getPath(node.left, current_path,result);
            if(node.right!=null) getPath(node.right,current_path,result);
        }
        current_path.setLength(len);
    }

//        public static List<String> binaryTreePaths(TreeNode root) {
//            ArrayList<String> ar = new ArrayList<>();
//            if(root == null)    return ar;
//            StringBuilder curr = new StringBuilder();
//            fn(root, ar, curr);
//            return ar;
//        }
//
//        public static void fn(TreeNode root, ArrayList<String> ar, StringBuilder curr)
//        {
//            if(root == null)
//                return;
//            int len = curr.length();
//            curr.append(root.val);
//            if(root.left == null && root.right == null)
//                ar.add(curr.toString());
//            else
//            {
//                curr.append("->");
//                fn(root.left, ar, curr);
//                fn(root.right, ar, curr);
//            }
//            curr.setLength(len);
//        }

}
