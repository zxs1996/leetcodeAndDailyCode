package num_201_300;

public class Num_226 {

    public TreeNode invertTree(TreeNode root) {
        if(root==null)
            return null;
        //递归交换root的左右子树
        TreeNode left=invertTree(root.left);
        TreeNode right=invertTree(root.right);
        root.left=right;
        root.right=left;
        return root;
    }
}
