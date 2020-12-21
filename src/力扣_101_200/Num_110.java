package 力扣_101_200;

/**
 * Created by zxs666 on 2020/7/19.
 */
public class Num_110 {
    public boolean isBalanced(TreeNode root) {
        return !(postOrder(root) == -1);
    }

    public int postOrder(TreeNode root) {
        if (root == null)
            return 0;
        int left = postOrder(root.left);
        int right = postOrder(root.right);
        //如果左边失衡，或者右边失衡，或者当前节点左右高度差超过1，那么返回-1
        if (left == -1 || right == -1 || Math.abs(left - right) > 1)
            return -1;
        //返回较高的子树高度
        return Math.max(left, right)+1;
    }
}
