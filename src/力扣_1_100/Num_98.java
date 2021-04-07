package 力扣_1_100;

import javafx.util.Pair;

/**
 * @author zxs666
 * @date 2021/2/20 21:34
 */
public class Num_98 {
    public boolean isValidBST(TreeNode root) {
        return isv(root,Long.MIN_VALUE,Long.MAX_VALUE);

    }

    //该子树的不能低于的最小值，和不能超过的最大值
    public boolean isv(TreeNode root, long min, long max) {
        if (root == null)
            return true;
        if (root.val <= min || root.val >= max)
            return false;
        return isv(root.left, min, root.val) && isv(root.right, root.val, max);
    }
}
