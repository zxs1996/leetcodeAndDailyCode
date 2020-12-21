package 力扣_101_200;

/**
 * Created by zxs666 on 2020/7/19.
 */
public class Num_112 {

    public boolean hasPathSum(TreeNode root, int sum) {
        return preOrder(root, 0, sum);
    }

    public boolean preOrder(TreeNode root, int parentSum, int target) {
        if (root == null)
            return false;
        //如果是叶节点
        if (root != null && root.left == null && root.right == null && parentSum + root.val == target)
            return true;

        //如果不是叶节点，返回左右子树的或
        return preOrder(root.left, parentSum + root.val, target) || preOrder(root.right, parentSum + root.val, target);

    }
}
