package num_101_200;

import sun.reflect.generics.tree.Tree;

import java.util.Arrays;

/**
 * Created by zxs666 on 2020/7/19.
 */
public class Num_114 {

    public static void main(String[] args) {
    }

    public void flatten(TreeNode root) {
        while (root != null) {
            //如果左子树为空，那么直接去右子树
            if (root.left == null) {
                root = root.right;
            } //左子树不为空，找左子树的最右节点
            else {
                TreeNode pre = root.left;
                while (pre.right != null) {
                    pre = pre.right;
                }
                //将原来的右子树接到左子树的最右边节点
                pre.right = root.right;
                // 将左子树插入到右子树的地方
                root.right = root.left;
                root.left = null;
                // 考虑下一个节点
                root = root.right;
            }
        }
    }


}
