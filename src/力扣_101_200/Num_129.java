package 力扣_101_200;

/**
 * Created by zxs666 on 2020/7/22.
 */
public class Num_129 {
    int res = 0;

    public int sumNumbers(TreeNode root) {
        preOrder(root, 0);
        return res;
    }

    public void preOrder(TreeNode root, int ans) {
        if (root == null)
            return;
        if (root.left == null && root.right == null) {
            ans = ans * 10 + root.val;
            res += ans;
        }
        preOrder(root.left, ans * 10 + root.val);
        preOrder(root.right, ans * 10 + root.val);
    }

}
