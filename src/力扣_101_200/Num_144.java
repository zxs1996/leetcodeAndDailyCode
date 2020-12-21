package 力扣_101_200;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by zxs666 on 2020/7/25.
 */
public class Num_144 {

    //前序遍历递归算法
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        preOrder(root, res);
        return res;

    }

    public void preOrder(TreeNode root, List<Integer> res) {
        if (root == null)
            return;
        res.add(root.val);
        preOrder(root.left, res);
        preOrder(root.right, res);
    }

    //前序遍历非递归算法
    public List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;//初始为null

        //当stack不为空的时候或者node不为null时
        while (stack.size() > 0 || node != null) {
            if (node == null)
                node = stack.pop();
            res.add(node.val);
            //如果right不为空，那么放入right
            if (node.right != null)
                stack.add(node.right);
            //往左边走
            if (node.left != null)
                node = node.left;
            else
                node = null;
        }
        return res;
    }


    //前序遍历非递归算法
    public List<Integer> preorderTraversal3(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = root;//初始为null
        //当stack不为空的时候或者node不为null时
        while (stack.size() > 0 || p != null) {
            if (p != null) {
                res.add(p.val);
                stack.push(p);
                p = p.left;
            } else {

                //do-while一直找
                do {
                    p = stack.pop().right;
                } while (p == null&&stack.size()>0);
            }
        }
        return res;
    }
}
