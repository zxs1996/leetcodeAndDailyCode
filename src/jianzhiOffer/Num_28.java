package jianzhiOffer;

/**
 * @author zxs666
 * @date 2020/12/11 12:47
 * <p>
 * 判断二叉树是否是对称的。
 * 1、将二叉树的根节点的右子树翻转，
 * 2、判断root的左右子树是否结构数值完全相同
 */
public class Num_28 {

    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;
        //翻转右子树
        root.right = mirrorTree(root.right);
        //检查结构
        return check(root.left, root.right);
    }


    public TreeNode mirrorTree(TreeNode root) {
        if (root == null)
            return root;
        TreeNode left = mirrorTree(root.left);
        TreeNode right = mirrorTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }

    public boolean check(TreeNode left, TreeNode right) {
        if (left == null && right == null)
            return true;
        if (left == null && right != null)
            return false;
        else if (left != null && right == null)
            return false;
        return left.val == right.val && check(left.left, right.left) && check(left.right, right.right);
    }
}
