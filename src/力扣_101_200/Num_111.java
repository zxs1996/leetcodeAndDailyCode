package 力扣_101_200;

/**
 * Created by zxs666 on 2020/7/19.
 */
public class Num_111 {
    int minHeight = Integer.MAX_VALUE;

    public int minDepth(TreeNode root) {
        if (root == null)
            return 0;
        preOrder(root, 0);
        return minHeight;
    }

    public void preOrder(TreeNode root, int height) {
        if(root==null)
            return ;
        //如果到根节点
        if (root != null && root.left == null && root.right == null) {
            if (height < minHeight)
                minHeight = height + 1;//需要＋1，因为当前节点也要计算在内
            return;
        }
        preOrder(root.left, height + 1);
        preOrder(root.right, height + 1);

    }
}
