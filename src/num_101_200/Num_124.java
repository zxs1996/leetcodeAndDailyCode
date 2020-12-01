package num_101_200;

/**
 * Created by zxs666 on 2020/7/22.
 */
public class Num_124 {
    //记录最大值
    int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        postOrder(root);
        return max;
    }

    // 后续遍历，根据左右子树的路径长度的，每次更新max，然后返回一条最长的子路径
    public int postOrder(TreeNode root) {

        if (root == null)
            return 0;
        int left = postOrder(root.left);
        int right = postOrder(root.right);
        //左右两边都小于等于0
        if (left <= 0 && right <= 0) {
            max = Math.max(root.val, max);
            return root.val;
        }
        //两边都大于等于0
        else if (left >= 0 && right >= 0) {
            max = Math.max(root.val + left + right, max);
            return Math.max(left, right) + root.val;
        }
        //左边大于0，右边小于0
        else if (left > 0 && right <= 0) {
            max = Math.max(root.val + left, max);
            return root.val + left;
        }
        //左边小于0，右边大于0
        else if (left <= 0 && right > 0) {
            max = Math.max(root.val + right, max);
            return root.val + right;
        }
        return 0;
    }

}
