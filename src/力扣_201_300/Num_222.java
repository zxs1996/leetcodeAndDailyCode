package 力扣_201_300;

/**
 * Created by zxs666 on 2020/8/8.
 */
public class Num_222 {
    public int countNodes(TreeNode root) {
        return lastOrder(root);

    }

    public int lastOrder(TreeNode node) {
        if (node == null)
            return 0;
        return lastOrder(node.left) + lastOrder(node.right) + 1;
    }
}
