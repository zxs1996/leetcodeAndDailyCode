package 力扣_101_200;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zxs666 on 2020/7/21.
 * //路径总和
 */
public class Num_113 {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        preOrder(root, sum, 0, res, new ArrayDeque());
        return res;
    }

    public void preOrder(TreeNode root, int sum, int parentSum, List<List<Integer>> res, ArrayDeque queue) {
        if (root == null) {
            return;
        }
        //如果是叶节点,那么判断是否等于目标值
        if (root.left == null && root.right == null) {
            if (parentSum + root.val == sum) {
                queue.addLast(root.val);
                res.add(new ArrayList<>(queue));
                queue.removeLast();
            }
            return;
        }
        //否则不是叶节点，那么往下递归
        //左边递归
        queue.addLast(root.val);
        preOrder(root.left, sum, parentSum + root.val, res, queue);
        queue.removeLast();
        //右边递归
        queue.addLast(root.val);
        preOrder(root.right, sum, parentSum + root.val, res, queue);
        queue.removeLast();
    }
}
